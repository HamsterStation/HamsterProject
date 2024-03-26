package dome;

import java.util.ArrayList;

public class database {
	private ArrayList<CD> listCD = new ArrayList<CD>();
	private ArrayList<DVD> listDVD = new ArrayList<DVD>();
	private ArrayList<Item> listItem = new ArrayList<Item>();
	private ArrayList<MP3> listMP3 = new ArrayList<MP3>();

	public void add(Item item) {
		listItem.add(item);
	}

	public void list() {
		for (Item item : listItem) {
			item.print();
			System.out.println();
		}
	}

	public static void main(String[] args) {
		database db = new database();
		db.add(new CD("稻香",180, true, "good song", "jay", 1));
		db.add(new DVD("奥特曼", 10000, true, "good movie", "迪迦导演"));
		db.add(new MP3("稻香",180, true, "good song", 180, "jay"));
		db.list();
		}

}
