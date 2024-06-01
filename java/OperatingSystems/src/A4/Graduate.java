package A4;

import java.util.concurrent.*; 

public class Graduate extends Thread {
	Semaphore sem;
	public Graduate(Semaphore sem) {
		this.sem = sem;
	}
	public void say(String mess) {
		System.out.println("<Graduate> " + mess);
	}
	public void run()
    {
		say("Another day... wooo...");
		try {
			while (true) {
				sem.acquire();
				Thread.sleep(1000);
				if (Bowl.candy == 0) {
					Bowl.candy = Bowl.MAXCANDY;
					say("I don't get paid enough for this!");
					Bowl.status();
					Thread.sleep(1000);
				} else {
					say("eh good enough");
					Thread.sleep(500);
				}
				sem.release();
				Thread.sleep(3000);
			}
			
			
		} catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
		
    }

}
