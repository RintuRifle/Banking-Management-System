package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;

    Login() {
        setTitle("RESERVE BANK OF INDIA");

        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logorbi.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogo = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogo);
        logoLabel.setBounds(70, 10, 100, 100);
        add(logoLabel);

        l1 = new JLabel("<html><center>BEST BANK OF INDIA</center></html>", SwingConstants.CENTER);
        l1.setFont(new Font("Osward", Font.BOLD, 28));
        l1.setBounds(150, 40, 500, 60);
        l1.setForeground(new Color(25, 25, 112));
        add(l1);

        l2 = new JLabel("Account No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        l2.setForeground(new Color(0, 0, 128));
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300, 150, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128), 2));
        add(tf1);

        l3 = new JLabel("Password:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        l3.setForeground(new Color(0, 0, 128));
        add(l3);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 220, 230, 30);
        pf2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128), 2));
        add(pf2);

        b1 = createStyledButton("SIGN IN");
        b2 = createStyledButton("CLEAR");
        b3 = createStyledButton("SIGN UP", new Color(34, 139, 34));

        b1.setBounds(300, 300, 100, 40);
        b2.setBounds(430, 300, 100, 40);
        b3.setBounds(300, 350, 230, 40);

        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(null);

        setSize(800, 480);
        setLocation(550, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createStyledButton(String text) {
        return createStyledButton(text, new Color(0, 0, 128));
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 2, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                Conn c1 = new Conn();
                String cardno = tf1.getText();
                String pin = pf2.getText();
                String query = "select * from login where cardno = '" + cardno + "' and pin = '" + pin + "'";

                ResultSet rs = c1.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
            } else if (ae.getSource() == b3) {
                setVisible(false);
                new Signup().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
