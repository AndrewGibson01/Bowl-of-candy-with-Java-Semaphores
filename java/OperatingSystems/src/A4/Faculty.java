package A4;

import java.util.concurrent.*; 

public class Faculty extends Thread{
	Semaphore sem;
	public int id = 0;
	
	public Faculty(Semaphore sem, int id) {
		this.sem = sem;
		
		this.id = id;
	}
	public void say(String mess) {
		System.out.println("<Faculty " + this.id + "> " + mess);
	}
	public void run()
    {
        say("I have been born!");
        try {
        	while (true) {
        		sem.acquire();
            	Thread.sleep(1000);
            	if (Bowl.candy > 0) {
            		Bowl.candy--;
                	say("MMM this is some good candy!");
                	Thread.sleep(1500);
            	} else {
            		say("Hey what gives! This is empty!");
            	}
            	Bowl.status();
            	Thread.sleep(500);
            	say("Fine! You can have it!");
            	Thread.sleep(500);
            	sem.release();
            	Thread.sleep(3000);
        		}
        	} catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }
}
