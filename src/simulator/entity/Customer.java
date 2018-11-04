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
	public static int LOOP_TRYING_THRESHOLD = 5;

	@Override
	public void run()
	{
		trolley = new Trolley( generator.getRandomNumberInRange( 0, 200 ) );
		List<CheckoutQueue> checkoutQueues = Demo.checkOutQueues;
		if ( !Demo.checkOutQueues.isEmpty() )
		{
			boolean foundAQueue = false;
			int loopCounter = 0;
			final long NANOSEC_PER_SEC = 1000l*1000*1000;
			long startTime = System.nanoTime();
			outerLoop:
			while((System.nanoTime()-startTime)< LOOP_TRYING_THRESHOLD*NANOSEC_PER_SEC)
			{
				loopCounter++;
				for ( CheckoutQueue queue : checkoutQueues )
				{
					Queue<Customer> customers = queue.getCustomers();
					Lock sharedLock = queue.getSharedLock();
					if ( sharedLock.tryLock() && queue.getMaximumProductCount() > trolley.getProductCount())
					{
						try
						{
							if ( customers.size() < 6 )
							{
								customers.add( this );
								JTextField textField = Demo.getDemoInstance().getUi().getCheckOutAssociationMap().get( queue.getQueueId() );
								textField.setText( Integer.toString( customers.size() ) );
								System.out.println( "Current Customers in the " + queue.getCheckOutName() + " Checkout Queue : " + customers.size() );
								queueJoinedTime = System.currentTimeMillis();
								foundAQueue = true;
								if(customers.size() == 1)
								{
									queue.getCondition().signal();
								}	
								break outerLoop;
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
//				if(loopCounter == LOOP_TRYING_THRESHOLD)
//				{
//					// Customer tried adding himself to a Checkout Queue for LOOP_TRYING_THRESHOLD. So here it will leave the market
//					lostCustomers++;
//					//break;
//				}
			}
			if(!foundAQueue)
			{
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
