package simulator.entity;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

import simulator.util.RandomNumberGenerator;

/**
 * @author Shamitha This class acts as the real world Checkout of a Supermarket
 */
public class CheckoutQueue implements Runnable
{
	private Queue<Customer> customers;
	private RandomNumberGenerator generator;
	private String checkOutName;
	private int queueId;	

	public CheckoutQueue()
	{
		customers = new LinkedList<>();
		generator = new RandomNumberGenerator();
	}
	
	@Override
	public void run()
	{
		System.out.println( Thread.currentThread().getName() + " started..!!" );
		while ( true )
		{
			Customer customer = null;
			// System.out.println("Current Customers in Checkout Queue : "+Thread.currentThread().getName()+" ##" + customers.size());
			synchronized ( customers )
			{
				if ( customers.size() == 0 )
				{
					try
					{
						customers.wait();
					}
					catch ( InterruptedException e )
					{
						e.printStackTrace();
					}
				}
				else
				{
					customer = customers.poll();
					customers.notifyAll();
				}

			}
			if ( customer != null )
			{
				int trolleyProductCount = customer.getTrolley().getProductCount();
				for ( int i = 0; i < trolleyProductCount; i++ )
				{
					double tempTime = generator.getRandomDecimalNumberInRange( 0.5, 6 );
					long scanTime = ( long ) tempTime * 1000;
					DecimalFormat df = new DecimalFormat( "#.##" );
					//System.out.println( df.format( tempTime ) );
					try
					{
						Thread.sleep( scanTime );
					}
					catch ( InterruptedException e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println( "Customer ID : "+customer.getCustomerId()+" total waiting time in queue : " + customer.getWaitingTimeInQueue( System.currentTimeMillis() )+" ## Product count : "+customer.getTrolley().getProductCount() );
			}
		}
	}

	public String getCheckOutName()
	{
		return checkOutName;
	}
	
	public void setCheckOutName( String checkOutName )
	{
		this.checkOutName = checkOutName;
	}
	
	public Queue<Customer> getCustomers()
	{
		return customers;
	}
	
	public void setCustomers( Queue<Customer> customers )
	{
		this.customers = customers;
	}
	
	public int getQueueId()
	{
		return queueId;
	}

	public void setQueueId( int queueId )
	{
		this.queueId = queueId;
	}
}
