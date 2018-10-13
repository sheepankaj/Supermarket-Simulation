package simulator.demos;

import java.util.ArrayList;
import java.util.List;

public class WaitCheck implements Runnable{
	
	WaitCheck wc;
	List<String> strList = new ArrayList();
	
	public static void main(String[] args) {
		WaitCheck wc = new WaitCheck();
		new Thread(wc).start();
		WaitCheckWaiter wcw = new WaitCheckWaiter(wc);
		new Thread(wcw).start();
	}
	
	

	@Override
	public void run() {
		synchronized (strList) {
			if(strList.size() == 0)
			{
				try {
					System.out.println("Just Before wait..");
					strList.wait();
					System.out.println("Just after wait..");
					// printing the added value
					System.out.println("Value : "+strList.get(0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("In else statement..!!");
			}
		}
		System.out.println("After synch WaitCheck");
		
	}

}
