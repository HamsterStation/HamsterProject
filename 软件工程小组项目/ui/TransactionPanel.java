package ui;

import javax.swing.*;

public class TransactionPanel extends JPanel {
    public TransactionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Transaction History"));
        
        // Add more components as needed
    }
}
