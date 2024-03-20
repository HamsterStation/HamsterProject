
package clock;

public class colock {
	private display minute = new display(60);
	private display hour = new display(24);
	private display second = new display(60);
	
	public colock(int hour,int minute,int second) {
		this.hour.setValue(hour);
		this.minute.setValue(minute);
		this.second.setValue(second);
	}
	
	public void tick() {
		second.increase();
	}
	
	public String toString() {
		
		return String.format("%02d:%02d:%02d\n",hour.getValue(),minute.getValue(),second.getValue());
	}
	
	public void start() {
		for(;;) {
			System.out.printf("%02d:%02d\n",hour.getValue(),minute.getValue());
			minute.increase();
			if(minute.getValue() == 0) {
				hour.increase();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
