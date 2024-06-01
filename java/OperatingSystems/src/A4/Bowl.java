package A4;

public class Bowl {
	public static int candy;
	public static int MAXCANDY;
	
	public Bowl(int candy2, int maxy2) {
		candy = candy2;
		MAXCANDY = maxy2;
	}
	public static void status() {
		System.out.println("The bowl has " + candy + " pieces of candy.");
	}
}
