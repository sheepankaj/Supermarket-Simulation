package simulator.entity;

import java.util.List;
import java.util.Queue;

import simulator.demos.Demo;
import simulator.util.RandomNumberGenerator;

/**
 * Created by Shamitha on 15-Sep-18.
 */
public class Customer implements Runnable {

	private Trolley trolley;
	private RandomNumberGenerator generator = new RandomNumberGenerator();

	@Override
	public void run() {
		trolley = new Trolley(generator.getRandomNumberInRange(0, 200));
		List<CheckoutQueue> checkoutQueues = Demo.checkOutQueues;
		if (!Demo.checkOutQueues.isEmpty()) 
		{
			for (CheckoutQueue queue : checkoutQueues) 
			{
				Queue<Customer> customers = queue.getCustomers();
				synchronized (customers) 
				{
					if (customers.size() < 6) 
					{
						customers.add(this);
						customers.notifyAll();
						break;
					}
					else
					{
						// need to release Checkout Queue's customer list
						customers.notifyAll();
					}
				}
			}
		} 
		else 
		{
			try 
			{
				System.out.println("Going to Wait : " + Thread.currentThread().getName());
				wait();
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Trolley getTrolley() {
		return trolley;
	}

	public void setTrolley(Trolley trolley) {
		this.trolley = trolley;
	}

}
