package A4;

import java.io.*;
import java.util.concurrent.*; 

public class A4main {

	public static void main(String[] args) throws IOException {
		Semaphore sem = new Semaphore(1); 
		
		BufferedReader bfn = new BufferedReader(
	            new InputStreamReader(System.in));
		
		// String strin = bfn.readLine();
		
		System.out.print("Number of Faculty Members? ");	
		int numFaculty = Integer.parseInt(bfn.readLine());
		
		System.out.print("Number of Candy in the bowl? ");
		int numCandy = Integer.parseInt(bfn.readLine());
		
		@SuppressWarnings("unused")
		Bowl bowl = new Bowl(numCandy, numCandy);
		Faculty[] staff = new Faculty[numFaculty];
		for (int i = 0; i < numFaculty; i++) {
			staff[i] = new Faculty(sem, i);
			staff[i].start();
		}
		Graduate grad = new Graduate(sem);
		grad.start();
		
		/*
		Faculty f1 = new Faculty(sem);
		Faculty f2 = new Faculty(sem);
		f1.start();
		f2.start();
		*/
	}

}
