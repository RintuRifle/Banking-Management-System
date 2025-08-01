package ASimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoanStatus extends JFrame {

    String pin;
    JLabel l1;
    JButton b1;

    LoanStatus(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l2.add(l1);

        b1.setBounds(390, 633, 150, 35);
        l2.add(b1);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from loan where pin = '" + pin + "'");
            double totalLoan = 0, totalRepayment = 0;

            while (rs.next()) {
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");

                if (type.equals("Loan")) {
                    totalLoan += amount;
                } else if (type.equals("Repayment")) {
                    totalRepayment += amount;
                }
            }

            double loanBalance = totalLoan - totalRepayment;
            l1.setText("Your Current Loan Balance is: Rs. " + loanBalance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        });

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoanStatus("").setVisible(true);
    }
}
