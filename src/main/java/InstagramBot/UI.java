package InstagramBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {

    public void createUi() {
        JFrame mainFrame = new JFrame("Instagram");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(350, 100));

        GridLayout loginLayout = new GridLayout(3,2);
        mainFrame.setLayout(loginLayout);

        mainFrame.add(new JLabel("Логин"));
        mainFrame.add(new JTextField());
        mainFrame.add(new JLabel("Пароль"));
        mainFrame.add(new JTextField());
        JButton authButton = new JButton("Войти");

        authButton.addActionListener(this);
        mainFrame.add(authButton);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.startBot();
    }
}