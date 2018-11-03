package simulator.util;

import simulator.entity.Customer;
import simulator.ui.SimulatorUI;

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
			try 
			{
				ui.getTxNoOfLostCustomers().setText( Integer.toString(Customer.lostCustomers));
				// updating UI having 5 sec time gaps
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

}
