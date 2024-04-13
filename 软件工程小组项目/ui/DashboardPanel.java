package ui;

import javax.swing.*;

public class DashboardPanel extends JPanel {
    private MainApplicationFrame mainFrame;

    public DashboardPanel(MainApplicationFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Welcome to your Dashboard"));
        
        // Here you can add more components as needed
    }
}
