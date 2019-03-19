package InstagramBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    private JFrame mainFrame;
    private JTextField loginUser;
    private JTextField passwordUser;
    private JButton authButton;


    public void createUi() {
        mainFrame = new JFrame("Instagram");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(350, 100));

        GridLayout loginLayout = new GridLayout(3,2);
        mainFrame.setLayout(loginLayout);

        loginUser= new JTextField();
        passwordUser = new JTextField();
        authButton = new JButton("Войти");

        mainFrame.add(new JLabel("Логин"));
        mainFrame.add(loginUser);
        mainFrame.add(new JLabel("Пароль"));
        mainFrame.add(passwordUser);

        authButton.addActionListener(this);
        mainFrame.add(authButton);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.startBot(loginUser.getText(), passwordUser.getText());
    }
}