package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame implements ActionListener {
 
    JButton b1;
    JLabel l1;
    JTable table;
    DefaultTableModel model;
    
    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(600, 600);
        setLocation(20, 20);

        // Add the header label
        JLabel l2 = new JLabel("RESERVE BANK OF INDIA");
        l2.setBounds(200, 20, 200, 20);
        add(l2);

        // Table for displaying mini statement
        String[] columns = {"Time", "Credit", "Debit"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setBounds(20, 80, 550, 350);
        table.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 80, 550, 350);
        add(sp);

        // Balance label
        l1 = new JLabel();
        l1.setBounds(20, 440, 400, 20);
        add(l1);

        // Exit button
        b1 = new JButton("Exit");
        add(b1);
        b1.addActionListener(this);
        b1.setBounds(20, 480, 100, 25);

        // Retrieve card number and show on mini statement
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '"+pin+"'");
            while (rs.next()) {
                l2.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retrieve transactions and populate table
        try {
            int balance = 0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pin+"'");
            while (rs.next()) {
                String time = rs.getString("date");
                String mode = rs.getString("mode");
                String amount = rs.getString("amount");

                // Add data to the table
                if (mode.equals("Deposit")) {
                    model.addRow(new Object[]{time, amount, ""});  // Credit
                    balance += Integer.parseInt(amount);
                } else {
                    model.addRow(new Object[]{time, "", amount});  // Debit
                    balance -= Integer.parseInt(amount);
                }
            }
            l1.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
