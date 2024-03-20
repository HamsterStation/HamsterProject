package clock;

public class Main {
	public static void main(String[] arg) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		colock colock = new colock(in.nextInt(),in.nextInt(),in.nextInt());
		colock.tick();
		System.out.println(colock);
		in.close();
	}
}
