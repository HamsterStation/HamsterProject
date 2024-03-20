package clock;

public class display {
	
	private int value = 0;
	private int limit = 0;
	
	display(int limit){
		this.limit = limit;
	}
	
	public void increase() {
		value++;
		if(value == limit) {
			value = 0;
		}	
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public static void main(String[] args) {
		
	}
	
	

}
