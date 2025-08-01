package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LoanRepayment extends JFrame implements ActionListener {
    
    JTextField t1;
    JButton b1, b2;
    JLabel l1;
    String pin;

    LoanRepayment(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO REPAY");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("REPAY");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l2.add(l1);

        t1.setBounds(190, 420, 320, 25);
        l2.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l2.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l2.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to repay.");
                } else {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into loan values('" + pin + "', '" + date + "', 'Repayment', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Repaid Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoanRepayment("").setVisible(true);
    }
}
