package notebook;

import java.util.ArrayList;

public class notebook {
	
	private ArrayList<String> note = new ArrayList<String>();
	
	public void add(String s) {
		note.add(s);
	}
	
	public void add(String s,int location) {
		note.add(location, s);
	}
	
	public int getSize() {
		return note.size();
	}
	
	public String getNote(int index) {
		return note.get(index);
	}
	
	public void removeNote(int index) {
		note.remove(index);
	}
	
	public String[] list() {
		String[] a = new String[note.size()];
		note.toArray(a);
		return a;
	}
	
	public void printList(String[] a) {
		for(String s : a) {
			System.out.println(s);
		}
	}
	
	
	public static void main(String[] arg) {
		notebook nb = new notebook();
		nb.add("First");
		nb.add("Second");
		System.out.println(nb.getSize());
		nb.add("Third", 1);
		String[] a = nb.list();
		nb.printList(a);
		
	}
}
