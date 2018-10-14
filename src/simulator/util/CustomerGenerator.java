package simulator.util;

import simulator.demos.Demo;
import simulator.entity.Customer;

public class CustomerGenerator {
	RandomNumberGenerator generator;
	static int customerCounter;
	
	
	public CustomerGenerator()
	{
		generator = new RandomNumberGenerator();
	}

	public void generateCustomersPerGivenTime(final long timeInterval, final int maximumNumberOfCustomers) 
	{
		Runnable runnable = new Runnable() {

			public void run() {
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
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

		
	
	
}