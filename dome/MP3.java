package dome;

public class MP3 extends Item{
		private String artist;
		private double memory;

	
	public MP3(String title, int playingTime,boolean gotIt, String comment,double memory,String artist) {
		super(title, playingTime, gotIt, comment);
		this.memory = memory;
		this.artist = artist;		
	}
	
	
	
	@Override
	public String toString() {
		return "MP3 [artist=" + artist + ", memory=" + memory ;
	}



	public void print() {
		System.out.print(toString()+" ");
		super.print();
	
	}

	public static void main(String[] args) {
		MP3 mp3 = new MP3("稻香",180, true, "good song", 180, "jay");
		mp3.print();
	}

}
