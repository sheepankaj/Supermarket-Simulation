package simulator.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import simulator.demos.Demo;
import simulator.entity.CheckoutQueue;
import simulator.entity.Customer;
import simulator.ui.SimulatorUI;

/**
 * @author Juliyanage Silva 18059546 
 * This class runs as a separate thread and collects stats from Customers and the checkouts
 * upon them, updates the UI
 */
public class StatCalculator implements Runnable
{
	SimulatorUI ui ;
	
	
	public StatCalculator(SimulatorUI ui)
	{
		this.ui = ui;
	}	

	public SimulatorUI getUi()
	{
		return ui;
	}

	public void setUi( SimulatorUI ui )
	{
		this.ui = ui;
	}

	@Override
	public void run()
	{		
		while(true)
		{
			int currentlyProcessingCustomers = 0;
			int totalProductsProcessed = 0;
			double totalWaitingTimeForCustomer = 0;			
			double totalUtilizationTime = 0;			
			double totalCheckoutOpenedTime = 0;	
			double singleUtilizationTotal = 0;
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.CEILING);
			try 
			{
				
				ui.getTxNoOfLostCustomers().setText( Integer.toString(Customer.lostCustomers));
				for(CheckoutQueue queue : Demo.checkOutQueues)
				{
					boolean isStatLockAquired = queue.getSharedLockOnStats().tryLock();
					if(isStatLockAquired)
					{
						try
						{
							currentlyProcessingCustomers += queue.getTotalCustomersProcessed();
							totalWaitingTimeForCustomer += queue.getTotalCustomerWaitingTime();
							totalProductsProcessed += queue.getTotalProductsProcessed();
							totalUtilizationTime += queue.getTotalUtilizingTime();
							totalCheckoutOpenedTime += queue.getCheckoutTotalAvailabiltyUptoNow( System.currentTimeMillis() );
							singleUtilizationTotal += queue.singelCheckoutUtilization();
						}
						finally {
							queue.getSharedLockOnStats().unlock();
						}
					}
					else
					{
						continue;
					}
					
				}
				ui.getTxCurrentlyProcessing().setText( Integer.toString( currentlyProcessingCustomers ) );
				ui.getTxTotProductsProcessed().setText( Integer.toString( totalProductsProcessed ) );
				ui.getTxTotWaitCustomer().setText(  df.format(totalWaitingTimeForCustomer/1000));				
				if(currentlyProcessingCustomers > 0)
				{
					ui.getTxAvgCustomerWaitTime().setText( df.format(totalWaitingTimeForCustomer/(1000* currentlyProcessingCustomers)));
					ui.getTxAvgProductsPerTrolley().setText(Integer.toString( totalProductsProcessed/currentlyProcessingCustomers));
				}
				if(totalCheckoutOpenedTime > 0)
				{
					ui.getTxTotUtiForCheckout().setText(df.format((totalUtilizationTime/totalCheckoutOpenedTime)*100));
					ui.getTxAvgCheckoutUtilization().setText(df.format(singleUtilizationTotal/8));
				}
				// updating UI having 5 sec time gaps
				Thread.sleep(1000);
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
