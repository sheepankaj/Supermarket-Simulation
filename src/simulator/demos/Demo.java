package simulator.demos;

import java.util.ArrayList;
import java.util.List;

import simulator.entity.CheckoutQueue;
import simulator.ui.SimulatorUI;
import simulator.util.CustomerGenerator;

public class Demo 
{
	public static List<CheckoutQueue> checkOutQueues = new ArrayList<>();
	private List<Thread> checkOutQueueThreads;
	private static Demo demo;
	private CustomerGenerator customerGenerator;
	
	public static void main(String[] args) 
	{
		SimulatorUI ui = new SimulatorUI();
		ui.setVisible(true);
		Demo demo = new Demo();
		demo.startCheckoutQueues();
		demo.customerGenerator.generateCustomersPerGivenTime(1);
	}
	
	private Demo()
	{
		customerGenerator = new CustomerGenerator();
		checkOutQueueThreads = new ArrayList<>();
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
		for(int i = 0; i < 9; i++)
		{
			CheckoutQueue queue = new CheckoutQueue();
			Thread t = new Thread(queue,"Checkout Queue : "+i);
			checkOutQueues.add(queue);
			checkOutQueueThreads.add(t);
			t.start();
		}
	}

}
