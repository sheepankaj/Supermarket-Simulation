package simulator.demos;

import java.util.ArrayList;
import java.util.List;

import simulator.entity.CheckoutQueue;
import simulator.entity.Customer;
import simulator.ui.SimulatorUI;
import simulator.util.CustomerGenerator;

public class Demo 
{
	public static List<CheckoutQueue> checkOutQueues = new ArrayList<>();
	private List<Thread> checkOutQueueThreads;
	private static Demo demo;
	private CustomerGenerator customerGenerator;
	private List<Customer> customersInSystem;
	private SimulatorUI ui;

	public static void main(String[] args) 
	{		
		SimulatorUI ui = new SimulatorUI();
		ui.setVisible(true);		
		Demo demo = getDemoInstance();
		demo.setUi( ui );
		demo.startCheckoutQueues();
		demo.customerGenerator.generateCustomersPerGivenTime(1,200);
	}
	
	private Demo()
	{
		customerGenerator = new CustomerGenerator();
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
	
	private void startCheckoutQueues()
	{
		for(int i = 0; i < 8; i++)
		{
			CheckoutQueue queue = new CheckoutQueue();
			queue.setCheckOutName( "Checkout Queue : "+(i+1) );
			queue.setQueueId( i+1 );
			Thread t = new Thread(queue,queue.getCheckOutName());
			checkOutQueues.add(queue);
			checkOutQueueThreads.add(t);
			t.start();
		}
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
