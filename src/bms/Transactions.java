package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1, heading;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, exitButton;
    String pin;

    Transactions(String pin) {
        this.pin = pin;

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/Bank_image.jpg"));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledBackground = new ImageIcon(backgroundImg);
        JLabel backgroundLabel = new JLabel(scaledBackground);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        heading = new JLabel("RESERVE BANK OF INDIA", SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 26));
        heading.setOpaque(true);
        heading.setBackground(new Color(25, 25, 112));
        heading.setBounds(200, 20, 560, 40);
        heading.setBorder(new LineBorder(new Color(255, 215, 0), 4, true)); 
        backgroundLabel.add(heading);

        l1 = new JLabel("Please Select Your Transaction", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 20));
        l1.setOpaque(true);
        l1.setBackground(new Color(65, 105, 225));
        l1.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
        l1.setBounds(180, 340, 600, 40);
        backgroundLabel.add(l1);

        ImageIcon ashokStambhIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logorbi.png"));
        Image ashokStambhImg = ashokStambhIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel ashokStambhLabel = new JLabel(new ImageIcon(ashokStambhImg));
        ashokStambhLabel.setBounds(430, 390, 100, 100);
        backgroundLabel.add(ashokStambhLabel);

        b1 = createStyledButton("DEPOSIT");
        b2 = createStyledButton("CASH WITHDRAWAL");
        b3 = createStyledButton("FAST CASH");
        b4 = createStyledButton("PASSBOOK");
        b5 = createStyledButton("PIN CHANGE");
        b6 = createStyledButton("BALANCE ENQUIRY");
        b7 = createStyledButton("APPLY FOR LOAN");
        b8 = createStyledButton("LOAN REPAYMENT");
        b9 = createStyledButton("LOAN STATUS");

        setLayout(null);

        int xLeft = 240, xRight = 450, yStart = 500, yGap = 50;

        b1.setBounds(xLeft, yStart, 170, 40);
        backgroundLabel.add(b1);

        b2.setBounds(xRight, yStart, 170, 40);
        backgroundLabel.add(b2);

        b3.setBounds(xLeft, yStart + yGap, 170, 40);
        backgroundLabel.add(b3);

        b4.setBounds(xRight, yStart + yGap, 170, 40);
        backgroundLabel.add(b4);

        b5.setBounds(xLeft, yStart + 2 * yGap, 170, 40);
        backgroundLabel.add(b5);

        b6.setBounds(xRight, yStart + 2 * yGap, 170, 40);
        backgroundLabel.add(b6);

        b7.setBounds(xLeft, yStart + 3 * yGap, 170, 40);
        backgroundLabel.add(b7);

        b8.setBounds(xRight, yStart + 3 * yGap, 170, 40);
        backgroundLabel.add(b8);

        b9.setBounds(xLeft, yStart + 4 * yGap, 170, 40);
        backgroundLabel.add(b9);

        // Exit button at the bottom
        exitButton = createStyledButton("EXIT", new Color(220, 20, 60));
        exitButton.setBounds(xRight, yStart + 4 * yGap, 170, 40);
        backgroundLabel.add(exitButton);

        // Action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        exitButton.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        return createStyledButton(text, new Color(0, 0, 128));
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("System", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            setVisible(false);
            new LoanApplication(pin).setVisible(true);
        } else if (ae.getSource() == b8) {
            setVisible(false);
            new LoanRepayment(pin).setVisible(true);
        } else if (ae.getSource() == b9) {
            new LoanStatus(pin).setVisible(true);
        } else if (ae.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
