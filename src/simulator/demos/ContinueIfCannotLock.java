package simulator.demos;

import java.util.ArrayList;
import java.util.List;

public class ContinueIfCannotLock implements Runnable
{

	static List<LockingObject> lockObjects = new ArrayList();
	
	
	@Override
	public void run()
	{
		for(LockingObject obj : lockObjects)
		{
			synchronized ( obj )
			{
				// do things here
			}
		}
		
	}

}
