package ui;

import javax.swing.*;

public class LoginPanel extends JPanel {
    private MainApplicationFrame mainFrame;

    public LoginPanel(MainApplicationFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // 添加登录表单组件
        add(new JLabel("Username:"));
        add(new JTextField(20));
        add(new JLabel("Password:"));
        add(new JPasswordField(20));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Here you would handle the login logic
            mainFrame.switchToPanel(new DashboardPanel(mainFrame)); // Switch to DashboardPanel on login
        });
        add(loginButton);
        
        // TODO: 添加事件监听器来处理登录逻辑
    }
}
