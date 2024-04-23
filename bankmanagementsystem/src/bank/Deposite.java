package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JTextField t1;
    JButton b1;
    JButton b2;
    JLabel l1;
    String pin;

    Deposite(String pin) {
        this.pin = pin;
        this.l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        this.l1.setForeground(Color.BLACK);
        this.l1.setFont(new Font("System", Font.BOLD, 16));
        this.t1 = new JTextField();
        this.t1.setFont(new Font("Raleway", Font.BOLD, 22));
        this.b1 = new JButton("DEPOSIT");
        this.b2 = new JButton("EXIT");
        this.setLayout(null);
        this.l1.setBounds(150, 200, 400, 35);
        this.add(this.l1);
        this.t1.setBounds(150, 250, 400, 35);
        this.add(this.t1);
        this.b1.setBounds(250, 300, 100, 35);
        this.add(this.b1);
        this.b2.setBounds(360, 300, 100, 35);
        this.add(this.b2);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = this.t1.getText();
            Date date = new Date();
            if (ae.getSource() == this.b1) {
                if (this.t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                } else {
                    ConnectionFactory cf = new ConnectionFactory();
                    cf.stmt.executeUpdate("insert into bank values('" + this.pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    this.setVisible(false);
                    new Transactions(this.pin).setVisible(true);
                }
            } else if (ae.getSource() == this.b2) {
                System.exit(0);
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposite("").setVisible(true);
    }
}
