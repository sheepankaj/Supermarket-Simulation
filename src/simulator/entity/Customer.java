package simulator.entity;

import java.util.List;
import java.util.Queue;

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
		trolley = new Trolley( generator.getRandomNumberInRange( 0, 200 ) );
		List<CheckoutQueue> checkoutQueues = Demo.checkOutQueues;
		if ( !Demo.checkOutQueues.isEmpty() )
		{
			for ( CheckoutQueue queue : checkoutQueues )
			{
				Queue<Customer> customers = queue.getCustomers();
				synchronized ( customers )
				{
					if ( customers.size() < 6 )
					{
						customers.add( this );
						System.out.println( "Current Customers in the " + queue.getCheckOutName() + " Checkout Queue : " + customers.size() );
						// Demo.getDemoInstance().
						queueJoinedTime = System.currentTimeMillis();
						customers.notifyAll();
						break;
					}
					else
					{
						// need to release Checkout Queue's customer list gg
						// checking EE ide
						customers.notifyAll();
					}
				}
			}
		}
//		else 
//		{
//			try 
//			{
//				System.out.println("Going to Wait : " + Thread.currentThread().getName());
//				wait();
//			} 
//			catch (InterruptedException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

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
