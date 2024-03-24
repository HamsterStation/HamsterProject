package coin;

import java.util.HashMap;
import java.util.Scanner;

public class coin {
	
	private HashMap<Integer,String> coinnames = new HashMap<Integer,String>();
	
	public coin() {
		coinnames.put(1, "penny");
		coinnames.put(5, "nickel");
		coinnames.put(10, "dime");
		coinnames.put(25, "quarter");
		coinnames.put(50, "half-dollar");
	}
	
	public String getName(int key) {
		if(coinnames.containsKey(key))
			return coinnames.get(key);
		else
			return "Not Found";
		}
	
	public void printHash() {
		for(Integer k : coinnames.keySet()) {
			System.out.println(coinnames.get(k));
		}
	}
	public static void main(String[] args) {
		coin c = new coin();
//		Scanner in = new Scanner(System.in);
//		int key = in.nextInt();
//		
//		System.out.println(c.getName(key));
		c.printHash();
		

	}

}
