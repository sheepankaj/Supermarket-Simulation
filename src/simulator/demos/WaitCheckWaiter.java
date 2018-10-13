package simulator.demos;

import java.util.ArrayList;

public class WaitCheckWaiter implements Runnable{
	
	WaitCheck wc;
	public WaitCheckWaiter(WaitCheck wc)
	{
		this.wc = wc;
	}
	
	

	@Override
	public void run() {
		synchronized (wc.strList) {
			wc.strList.add("Added");
			wc.strList.notifyAll();
			for(int i = 0; i< 100;i++)
			{
				System.out.println(i);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Woke up");
			System.out.println("After Notifying");
		}
		System.out.println("After synch WaitCheckWaiter");
		
	}

}
