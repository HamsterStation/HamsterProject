package ui;

import javax.swing.*;

public class AccountPanel extends JPanel {
    public AccountPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Accounts Overview"));
        
        // Add more components as needed
    }
}
