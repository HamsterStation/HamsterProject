package dome;

public class DVD extends Item {
	private String director;

	public DVD(String title, int playingTime, boolean gotIt,String comment,String director) {
		super(title,playingTime,gotIt, comment);
		this.director = director;
		
		
	}
	
	
	
	@Override
	public String toString() {
		return "DVD [director=" + director ;
	}



	public void print() {
		System.out.print(toString()+" ");
		super.print();
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
