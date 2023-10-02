import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        String initialPassword = GeneratePassword.generatePassword();
        System.out.println("Generated Password: " + initialPassword);

        JFrame frame = new JFrame("Password Generator");
        frame.setSize(500, 150);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel passwordLabel = new JLabel("Password:");
        JTextField passwordField = new JTextField(20);
        JButton generateNewPasswordButton = new JButton("Generate New Password");
        JButton clearButton = new JButton("Clear");
        JButton copyButton = new JButton("Copy");

        passwordField.setText(initialPassword);
        generateNewPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = GeneratePassword.generatePassword();
                passwordField.setText(password);
                System.out.println(password);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.selectAll();
                passwordField.copy();
            }
        });

        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(generateNewPasswordButton);
        frame.add(clearButton);
        frame.add(copyButton);

        frame.setLayout(null);

        passwordLabel.setBounds(10, 14, 80, 20);
        passwordField.setBounds(80, 15, 200, 20);
        generateNewPasswordButton.setBounds(120, 45, 260, 20);
        clearButton.setBounds(290, 15, 80, 20);
        copyButton.setBounds(380, 15, 80, 20);

        frame.setVisible(true);
    }
}