package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField t1;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;
        this.getContentPane().setBackground(new Color(52, 152, 219)); // Changed background color
        this.setLayout(null);
        
        this.l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        this.l1.setForeground(Color.WHITE);
        this.l1.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font to Arial
        this.l1.setBounds(150, 100, 300, 20); // Adjusted label position
        this.add(this.l1);
        
        this.l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        this.l2.setForeground(Color.WHITE);
        this.l2.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font to Arial
        this.l2.setBounds(150, 150, 300, 20); // Adjusted label position
        this.add(this.l2);
        
        this.t1 = new JTextField();
        this.t1.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.t1.setBounds(150, 200, 300, 30); // Adjusted text field position
        this.add(this.t1);
        
        this.b1 = new JButton("WITHDRAW");
        this.b1.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font to Arial
        this.b1.setBounds(200, 250, 150, 30); // Adjusted button position
        this.add(this.b1);
        this.b1.addActionListener(this);
        
        this.b2 = new JButton("BACK");
        this.b2.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font to Arial
        this.b2.setBounds(200, 300, 150, 30); // Adjusted button position
        this.add(this.b2);
        this.b2.addActionListener(this);
        
        this.setSize(600, 400); // Adjusted window size
        this.setLocationRelativeTo(null); // Centered the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = this.t1.getText();
            Date date = new Date();
            if (ae.getSource() == this.b1) {
                if (this.t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the Amount to you want to Withdraw", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ConnectionFactory cf = new ConnectionFactory();
                    ResultSet rs = cf.stmt.executeQuery("select * from bank where pin = '" + this.pin + "'");
                    int balance = 0;

                    while (rs.next()) {
                        // Assuming the 'type' column indicates the transaction mode
                        String transactionType = rs.getString("type");
                        if (transactionType.equalsIgnoreCase("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }


                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(this, "Insufficient Balance", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    cf.stmt.executeUpdate("insert into bank values('" + this.pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(this, "Rs. " + amount + " Debited Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    new Transactions(this.pin).setVisible(true);
                }
            } else if (ae.getSource() == this.b2) {
                this.setVisible(false);
                new Transactions(this.pin).setVisible(true);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            System.out.println("error: " + var7);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
