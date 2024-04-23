package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener {
    JPasswordField t1;
    JPasswordField t2;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        this.getContentPane().setBackground(new Color(52, 152, 219)); // Changed background color
        this.setLayout(null);
        
        this.l1 = new JLabel("CHANGE YOUR PIN");
        this.l1.setFont(new Font("Arial", Font.BOLD, 24)); // Changed font to Arial
        this.l1.setForeground(Color.WHITE); // Set text color to white
        this.l1.setBounds(150, 100, 300, 35); // Adjusted label position
        this.add(this.l1);

        this.l2 = new JLabel("New PIN:");
        this.l2.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.l2.setForeground(Color.WHITE); // Set text color to white
        this.l2.setBounds(100, 200, 150, 30); // Adjusted label position
        this.add(this.l2);

        this.l3 = new JLabel("Re-Enter New PIN:");
        this.l3.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.l3.setForeground(Color.WHITE); // Set text color to white
        this.l3.setBounds(100, 250, 150, 30); // Adjusted label position
        this.add(this.l3);

        this.t1 = new JPasswordField();
        this.t1.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.t1.setBounds(250, 200, 150, 30); // Adjusted text field position
        this.add(this.t1);

        this.t2 = new JPasswordField();
        this.t2.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.t2.setBounds(250, 250, 150, 30); // Adjusted text field position
        this.add(this.t2);

        this.b1 = new JButton("CHANGE");
        this.b1.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.b1.setBounds(180, 320, 100, 30); // Adjusted button position
        this.add(this.b1);
        this.b1.addActionListener(this);

        this.b2 = new JButton("BACK");
        this.b2.setFont(new Font("Arial", Font.PLAIN, 16)); // Changed font to Arial
        this.b2.setBounds(300, 320, 100, 30); // Adjusted button position
        this.add(this.b2);
        this.b2.addActionListener(this);

        this.setSize(600, 500); // Adjusted window size
        this.setLocationRelativeTo(null); // Centered the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = this.t1.getText();
            String rpin = this.t2.getText();
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(this, "Entered PIN does not match", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ae.getSource() == this.b1) {
                if (this.t1.getText().isEmpty() || this.t2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter both new PINs", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                ConnectionFactory cf = new ConnectionFactory();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                String q3 = "update signupthree set pin = '" + rpin + "' where pin = '" + this.pin + "' ";
                cf.stmt.executeUpdate(q1);
                cf.stmt.executeUpdate(q2);
                cf.stmt.executeUpdate(q3);
                JOptionPane.showMessageDialog(this, "PIN changed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new Transactions(rpin).setVisible(true);
            } else if (ae.getSource() == this.b2) {
                new Transactions(this.pin).setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
