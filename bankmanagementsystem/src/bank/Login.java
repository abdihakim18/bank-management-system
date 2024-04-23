package bank;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1;
    JButton b2;
    JButton b3;

    Login() {
        
        this.l1 = new JLabel("WELCOME TO BANK");
        this.l1.setFont(new Font("Osward", 1, 38));
        this.l1.setBounds(200, 40, 450, 40);
        this.add(this.l1);
        this.l2 = new JLabel("Card No:");
        this.l2.setFont(new Font("Raleway", 1, 28));
        this.l2.setBounds(125, 150, 375, 30);
        this.add(this.l2);
        this.tf1 = new JTextField(15);
        this.tf1.setBounds(300, 150, 230, 30);
        this.tf1.setFont(new Font("Arial", 1, 14));
        this.add(this.tf1);
        this.l3 = new JLabel("PIN:");
        this.l3.setFont(new Font("Raleway", 1, 28));
        this.l3.setBounds(125, 220, 375, 30);
        this.add(this.l3);
        this.pf2 = new JPasswordField(15);
        this.pf2.setFont(new Font("Arial", 1, 14));
        this.pf2.setBounds(300, 220, 230, 30);
        this.add(this.pf2);
        this.b1 = new JButton("SIGN IN");
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.BLACK);
        this.b2 = new JButton("CLEAR");
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.BLACK);
        this.b3 = new JButton("SIGN UP");
        this.b3.setBackground(Color.BLACK);
        this.b3.setForeground(Color.BLACK);
        this.setLayout((LayoutManager)null);
        this.b1.setFont(new Font("Arial", 1, 14));
        this.b1.setBounds(300, 300, 100, 30);
        this.add(this.b1);
        this.b2.setFont(new Font("Arial", 1, 14));
        this.b2.setBounds(430, 300, 100, 30);
        this.add(this.b2);
        this.b3.setFont(new Font("Arial", 1, 14));
        this.b3.setBounds(300, 350, 230, 30);
        this.add(this.b3);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.b3.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(800, 480);
        this.setLocation(550, 200);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == this.b1) {
                ConnectionFactory cf = new ConnectionFactory();
                String cardno = this.tf1.getText();
                String pin = this.pf2.getText();
                String query = "SELECT * FROM login WHERE cardnumber='" + cardno + "' AND pin='" + pin + "'";
                try (ResultSet rs = cf.stmt.executeQuery(query)) {
                    if (rs.next()) {
                        this.setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                } // ResultSet is automatically closed here
            } else if (ae.getSource() == this.b2) {
                this.tf1.setText("");
                this.pf2.setText("");
            } else if (ae.getSource() == this.b3) {
                this.setVisible(false);
                new Signup().setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    } public static void main(String[] args) {
        new Login();
    }
}
