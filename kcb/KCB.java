package kcb;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class KCB {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTable table = new JTable(new KCBdata());
		JScrollPane pane = new JScrollPane(table);
		frame.add(pane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
