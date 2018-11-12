package simulator.demos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import simulator.entity.CheckoutQueue;
import simulator.entity.Customer;
import simulator.ui.SimulatorUI;
import simulator.util.CustomerGenerator;
import simulator.util.StatCalculator;

/**
 * This class is responsible for starting UI and other threads
 *
 */
public class Demo
{
	public static List<CheckoutQueue> checkOutQueues = new ArrayList<>();
	private List<Thread> checkOutQueueThreads;
	private static Demo demo;
	private CustomerGenerator customerGenerator;
	private StatCalculator statCalculator;
	private List<Customer> customersInSystem;
	private SimulatorUI ui;
	private static int[] below5ItemsCheckouts = { 4, 7}; // set the below 5 items checkouts
	public static int EXPRESS_CHECKOUT_ITEMS = 5;

	public static void main( String[] args )
	{
		SimulatorUI ui = new SimulatorUI();
		ui.setVisible( true );

	}

	private Demo()
	{
		customerGenerator = new CustomerGenerator( 200, 1 );
		statCalculator = new StatCalculator( ui );
		checkOutQueueThreads = new ArrayList<>();
		customersInSystem = new ArrayList<>();
	}

	public static Demo getDemoInstance()
	{
		if ( demo == null )
		{
			demo = new Demo();
		}
		return demo;
	}

	/**
	 * This method creates the CheckoutQueue instances which act like supermarket counters
	 */
	public void startCheckoutQueues()
	{
		// Added synchronization here so that CustomerGenerator thread won't start generating Customer threads until the checkout queues are generated
		synchronized ( checkOutQueues )
		{
			for ( int i = 0; i < 8; i++ )
			{
				CheckoutQueue queue = null;
				if ( contains( i + 1 ) )
				{
					queue = new CheckoutQueue( 5, ( i + 1 ) );
					ui.getCheckOutLabelAssociationMap().get( i + 1 ).setForeground( Color.GREEN);
				}
				else
				{
					queue = new CheckoutQueue( ( i + 1 ) );
				}
				checkOutQueues.add( queue );
			}
			checkOutQueues.notify();
		}
		
	}

	public void startCustomerGenerator()
	{
		new Thread( customerGenerator, "Customer Generator" ).start();
	}

	public void startStatCalculator( SimulatorUI ui )
	{
		statCalculator.setUi( ui );
		new Thread( statCalculator, "Stat Calculator" ).start();
	}

	/**
	 * This method checks if the CheckoutQueue's id number is inside below 5 items setup
	 * @param item
	 * @return
	 */
	public static boolean contains( int item )
	{
		for ( int n : below5ItemsCheckouts )
		{
			if ( item == n )
			{
				return true;
			}
		}
		return false;
	}

	public List<Customer> getCustomersInSystem()
	{
		return customersInSystem;
	}

	public void setCustomersInSystem( List<Customer> customersInSystem )
	{
		this.customersInSystem = customersInSystem;
	}

	public SimulatorUI getUi()
	{
		return ui;
	}

	public void setUi( SimulatorUI ui )
	{
		this.ui = ui;
	}
}
