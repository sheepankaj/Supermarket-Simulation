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

	@Override
	public void run()
	{
		trolley = new Trolley( generator.getRandomNumberInRange( 0, 4 ) );
		List<CheckoutQueue> checkoutQueues = Demo.checkOutQueues;
		if ( !Demo.checkOutQueues.isEmpty() )
		{
			boolean foundAQueue = false;
			while ( !foundAQueue )
			{
				for ( CheckoutQueue queue : checkoutQueues )
				{
					Queue<Customer> customers = queue.getCustomers();
					Lock sharedLock = queue.getSharedLock();
					if ( sharedLock.tryLock() )
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
								queue.getCondition().signalAll();								
								break;
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
