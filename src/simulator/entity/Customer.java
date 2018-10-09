package simulator.entity;

import java.util.List;

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
				synchronized (queue) 
				{
					if (queue.getCustomers().size() < 6) 
					{
						queue.getCustomers().add(this);
						break;
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
