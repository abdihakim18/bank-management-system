package bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel l1;
    JButton b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400); // Adjusted frame size
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(200, 200, 200)); // Light gray background
        this.setLayout(null);
        
        this.l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        this.l1.setForeground(Color.BLACK);
        this.l1.setFont(new Font("Arial", Font.BOLD, 16)); // Changed font to Arial
        this.l1.setBounds(50, 20, 300, 30); // Centered label
        this.add(this.l1);
        
        // Buttons
        int y = 70;
        String[] amounts = {"100", "500", "1000", "2000", "5000", "10000"};
        for (String amount : amounts) {
            JButton button = new JButton("Rs " + amount);
            button.setBounds(50, y, 150, 30);
            button.addActionListener(this);
            this.add(button);
            y += 40;
        }

        // Back button
        this.b7 = new JButton("BACK");
        this.b7.setBounds(200, 270, 150, 30);
        this.b7.addActionListener(this);
        this.add(this.b7);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == this.b7) {
                this.setVisible(false);
                (new Transactions(this.pin)).setVisible(true);
            } else {
                String amount = ((JButton) ae.getSource()).getText().substring(3);
                ConnectionFactory cf = new ConnectionFactory(); // Create connection
                ResultSet rs = cf.stmt.executeQuery("select * from bank where pin = '" + this.pin + "'");
                int balance = 0;

                while(rs.next()) {
                    String transactionType = rs.getString("type");
                    if (transactionType.equalsIgnoreCase("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != this.b7 && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog((Component)null, "Insufficient Balance");
                    return;
                }

                if (ae.getSource() == this.b7) {
                    this.setVisible(false);
                    (new Transactions(this.pin)).setVisible(true);
                } else {
                    Date date = new Date();
                    cf.stmt.executeUpdate("insert into bank values('" + this.pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog((Component)null, "Rs. " + amount + " Debited Successfully");
                    this.setVisible(false);
                    (new Transactions(this.pin)).setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new FastCash("").setVisible(true);
            });
        }
    
        

    }
    
