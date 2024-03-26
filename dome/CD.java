package dome;

public class CD extends Item {
	private String artist;
	private int numofTracks;

	public CD(String title, int playingTime,boolean gotIt, String comment,String artist, int numofTracks) {
		super(title,playingTime,gotIt, comment);
		this.artist = artist;
		this.numofTracks = numofTracks;
	}
	
	
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numofTracks=" + numofTracks ;
	}


	public void print() {
		System.out.print(toString()+" ");
		super.print();
	
	}


}
