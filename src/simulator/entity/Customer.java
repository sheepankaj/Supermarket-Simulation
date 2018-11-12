package simulator.entity;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

import javax.swing.JTextField;

import simulator.demos.Demo;
import simulator.util.RandomNumberGenerator;

/**
 * Created by Shamitha on 15-Sep-18.
 */
public class Customer implements Runnable
{
	private Trolley trolley;
	private RandomNumberGenerator generator = new RandomNumberGenerator();
	private long queueJoinedTime;
	private long trolleyCleardTime;
	private int customerId;
	public static volatile int lostCustomers;
	public static int LOOP_TRYING_THRESHOLD = 20;

	/**
	 * This constructor creates the customer thread having a unique name that helps in debug situations.
	 * @param customerID 
	 */
	public Customer( int customerID )
	{
		new Thread( this, "Customer ID : " + ( customerID ) ).start();
	}

	@Override
	public void run()
	{
		// get the trolley created with the random number of products
		trolley = new Trolley( generator.getRandomNumberInRange( 0, 200 ) );
		if(trolley.getProductCount() < 5)
		{
			System.out.println( "## BELOW 5 ##" );
		}
		List<CheckoutQueue> checkoutQueues = Demo.checkOutQueues;
		if ( !Demo.checkOutQueues.isEmpty() )
		{
			boolean foundAQueue = false;
			final long NANOSEC_PER_SEC = 1000l * 1000 * 1000;
			long startTime = System.nanoTime();
			// Try this loop for the specified threshold 
			outerLoop: while ( ( System.nanoTime() - startTime ) < LOOP_TRYING_THRESHOLD * NANOSEC_PER_SEC )
			{
				for ( CheckoutQueue queue : checkoutQueues )
				{
					Queue<Customer> customers = queue.getCustomers();
					// Try to get the lock, if not continue for the next iteration
					Lock sharedLock = queue.getSharedLock();
					if ( sharedLock.tryLock())
					{						
						try
						{
							if(( trolley.getProductCount() < Demo.EXPRESS_CHECKOUT_ITEMS ) && Demo.contains( queue.getQueueId()))
							{
								if ( customers.size() < 6 )
								{
									customers.add( this );
									JTextField textField = Demo.getDemoInstance().getUi().getCheckOutAssociationMap().get( queue.getQueueId() );
									textField.setText( Integer.toString( customers.size() ) );
									System.out.println( "Current Customers in the " + queue.getCheckOutName() + " Checkout Queue : " + customers.size() );
									// stamp the time when the customer joins the queue
									queueJoinedTime = System.currentTimeMillis();
									foundAQueue = true;
									if ( customers.size() == 1 )
									{
										queue.getCondition().signal();
									}
									break outerLoop;
								}
							}
							else if(queue.getMaximumProductCount() > trolley.getProductCount())
							{
								if ( customers.size() < 6 )
								{
									customers.add( this );
									JTextField textField = Demo.getDemoInstance().getUi().getCheckOutAssociationMap().get( queue.getQueueId() );
									textField.setText( Integer.toString( customers.size() ) );
									System.out.println( "Current Customers in the " + queue.getCheckOutName() + " Checkout Queue : " + customers.size() );
									// stamp the time when the customer joins the queue
									queueJoinedTime = System.currentTimeMillis();
									foundAQueue = true;
									if ( customers.size() == 1 )
									{
										queue.getCondition().signal();
									}
									break outerLoop;
								}
							}
						}
						finally
						{
							sharedLock.unlock();
						}
					}					
					else
					{
						continue;
					}
				}
			}
			if ( !foundAQueue )
			{
				// even after trying for the time limit, 
				// if it cannot get into a queue, customer is considered as a lost one
				lostCustomers++;
			}
		}
	}

	public long getQueueJoinedTime()
	{
		return queueJoinedTime;
	}

	public void setQueueJoinedTime( long queueJoinedTime )
	{
		this.queueJoinedTime = queueJoinedTime;
	}

	public long getTrolleyCleardTime()
	{
		return trolleyCleardTime;
	}

	public void setTrolleyCleardTime( long trolleyCleardTime )
	{
		this.trolleyCleardTime = trolleyCleardTime;
	}

	public Trolley getTrolley()
	{
		return trolley;
	}

	public void setTrolley( Trolley trolley )
	{
		this.trolley = trolley;
	}

	// This method gets the time difference 
	// by getting the difference between adding to the queue and finishing  
	public double getWaitingTimeInQueue( long trolleyClearedTime )
	{
		return ( trolleyClearedTime - queueJoinedTime ) / 1000;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId( int customerId )
	{
		this.customerId = customerId;
	}
}
