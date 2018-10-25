package simulator.util;

import simulator.ui.SimulatorUI;

public class StatCalculator implements Runnable
{
	SimulatorUI ui ;
	
	public StatCalculator(SimulatorUI ui)
	{
		this.ui = ui;
	}

	@Override
	public void run()
	{
		while(true)
		{
			//System.out.println( "Stat calc runnunt" );
		}
	}

}
