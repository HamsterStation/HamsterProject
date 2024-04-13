package ui;

import javax.swing.*;

public class TaskPanel extends JPanel {
    public TaskPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Tasks"));
        
        // Add more components as needed
    }
}
