package simulator.demos;

import java.util.ArrayList;
import java.util.List;

import simulator.entity.CheckoutQueue;
import simulator.entity.Customer;
import simulator.ui.SimulatorUI;
import simulator.util.CustomerGenerator;
import simulator.util.StatCalculator;

public class Demo 
{
	public static List<CheckoutQueue> checkOutQueues = new ArrayList<>();
	private List<Thread> checkOutQueueThreads;
	private static Demo demo;
	private CustomerGenerator customerGenerator;
	private StatCalculator statCalculator;
	private List<Customer> customersInSystem;
	private SimulatorUI ui;
	private int [] below5ItemsCheckouts = {4,7};

	public static void main(String[] args) 
	{		
		SimulatorUI ui = new SimulatorUI();
		ui.setVisible(true);	
		
	}
	
	private Demo()
	{
		customerGenerator = new CustomerGenerator(200,1);
		statCalculator = new StatCalculator( ui );
		checkOutQueueThreads = new ArrayList<>();
		customersInSystem = new ArrayList<>();
	}
	
	public static Demo getDemoInstance()
	{
		if(demo == null)
		{
			demo = new Demo();
		}
		return demo;
	}
	
	public void startCheckoutQueues()
	{
		for(int i = 0; i < 8; i++)
		{
			CheckoutQueue queue = null;
			if(contains( i+1 ))
			{
				queue = new CheckoutQueue(5);
			}
			else
			{
				queue = new CheckoutQueue();
			}			 
			queue.setCheckOutName( "Checkout Queue : "+(i+1) );
			queue.setQueueId( i+1 );
			Thread t = new Thread(queue,queue.getCheckOutName());
			checkOutQueues.add(queue);
			checkOutQueueThreads.add(t);
			t.start();
		}
	}
	
	public void startCustomerGenerator()
	{
		new Thread(customerGenerator,"Customer Generator").start();
	}
	
	public void startStatCalculator(SimulatorUI ui)
	{
		statCalculator.setUi( ui );
		new Thread(statCalculator,"Stat Calculator").start();
	}
	
	private boolean contains(int item) {
	      for (int n : this.below5ItemsCheckouts) {
	          if (item == n) {
	             return true;
	          }
	       }
	       return false;
	}
	
	public List<Customer> getCustomersInSystem() {
		return customersInSystem;
	}

	public void setCustomersInSystem(List<Customer> customersInSystem) {
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
