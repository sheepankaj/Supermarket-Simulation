package simulator.util;

import simulator.demos.Demo;
import simulator.entity.Customer;

public class CustomerGenerator implements Runnable{
	RandomNumberGenerator generator;
	static int customerCounter;
	int maximumNumberOfCustomers;
	int timeInterval;	
	
	public CustomerGenerator(int maximumNumberOfCustomers,int timeInterval)
	{
		generator = new RandomNumberGenerator();
		this.maximumNumberOfCustomers = maximumNumberOfCustomers;
		this.timeInterval = timeInterval;
	}

	@Override
	public void run()
	{		
		synchronized ( Demo.checkOutQueues )
		{
			if(Demo.checkOutQueues.size() == 0)
				try
				{
					// Wait until Demo thread creating CheckoutQueues
					Demo.checkOutQueues.wait();
				}
				catch ( InterruptedException e )
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// Create customers only upto the defined number since for a large number of Customer threads will make memory issues
		while ( customerCounter < maximumNumberOfCustomers ) 
		{
			int randomNumOfCustomers = generator.getRandomNumberInRange(0, 60);
			//int randomNumOfCustomers = 200;
			for(int i = 0; i < randomNumOfCustomers;i++)
			{
				customerCounter++;
				int customerId = customerCounter;
				Customer customer = new Customer(customerId);
				Demo.getDemoInstance().getCustomersInSystem().add(customer);
			}
			System.out.println("###Created Customers### : "+customerCounter);		
			Demo.getDemoInstance().getUi().getTxTotalCustomersInMarket().setText( Integer.toString( customerCounter ) );
			try 
			{
				Thread.sleep(timeInterval*60*1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();

			}
		}		
	}	
}