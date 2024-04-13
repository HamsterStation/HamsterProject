package ui;

import javax.swing.*;

public class MainApplicationFrame extends JFrame {

    public MainApplicationFrame() {
        setTitle("Virtual Bank Application for Kids");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window
        
        // 初始化和显示 LoginPanel 或者 DashboardPanel，取决于用户是否已经登录
        // 这里假设用户未登录，先显示 LoginPanel
        setContentPane(new LoginPanel(this));
    }
    // Method to switch panels
    public void switchToPanel(JPanel panel) {
        setContentPane(panel);
        invalidate();
        validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApplicationFrame frame = new MainApplicationFrame();
            frame.setVisible(true);
        });
    }
}
