package simulator.entity;

import java.util.LinkedList;
import java.util.Queue;

import simulator.util.RandomNumberGenerator;

/**
 * 
 * @author Shamitha
 * This class acts as the real world Checkout of a Supermarket
 */
public class CheckoutQueue implements Runnable
{
    private Queue<Customer> customers;
    private RandomNumberGenerator generator;
    
    public CheckoutQueue() {
    	customers = new LinkedList<>();
    	generator = new RandomNumberGenerator();
	}

	public Queue<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Queue<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" started..!!");
		while(true)
		{
			synchronized (customers) 
			{
				if(customers.size() == 0)
				{
					try 
					{
						customers.wait();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else
				{
					Customer customer = customers.poll();
					customers.notifyAll();
					int trolleyProductCount = customer.getTrolley().getProductCount();
					for(int i = 0; i < trolleyProductCount; i++)
					{
						double scanTime = generator.getRandomDecimalNumberInRange(0.5, 6);
						System.out.println(scanTime);
//							long time = scanTime*1000;
//							Thread.sleep(scanTime*1000);
					}
				}
				
			}
		}			
	}
}
