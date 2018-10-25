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
		while ( customerCounter < maximumNumberOfCustomers ) 
		{
			//int randomNumOfCustomers = generator.getRandomNumberInRange(0, 60);
			int randomNumOfCustomers = 13;
			for(int i = 0; i < randomNumOfCustomers;i++)
			{
				Customer customer = new Customer();
				Demo.getDemoInstance().getCustomersInSystem().add(customer);
				customerCounter++;
				int customerId = customerCounter;
				customer.setCustomerId( customerId );
				new Thread(customer,"Customer ID : "+(customerId)).start();
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