package simulator.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shamitha
 * This class acts as the real world Checkout of a Supermarket
 */
public class CheckoutQueue implements Runnable
{
    private Queue<Customer> customers;
    
    public CheckoutQueue() {
    	customers = new LinkedList<>();
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
		while(customers.size() > 0)
		{
			synchronized (customers) 
			{
				Customer customer = customers.poll();
				customers.notifyAll();
				int trolleyProductCount = customer.getTrolley().getProductCount();
				for(int i = 0; i < trolleyProductCount; i++)
				{
					
				}
			}
		}		
	}
}
