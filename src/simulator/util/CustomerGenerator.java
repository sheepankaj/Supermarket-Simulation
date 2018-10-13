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

	public void generateCustomersPerGivenTime(final long timeInterval) 
	{
		Runnable runnable = new Runnable() {

			public void run() {
				while (true) {
					int randomNumOfCustomers = generator.getRandomNumberInRange(0, 60);
					for(int i = 0; i < randomNumOfCustomers;i++)
					{
						Customer customer = new Customer();
						Demo.getDemoInstance().getCustomersInSystem().add(customer);
						new Thread(customer,"Customer ID : "+(++customerCounter)).start();
					}
					System.out.println("Created Customers : "+customerCounter);					
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


