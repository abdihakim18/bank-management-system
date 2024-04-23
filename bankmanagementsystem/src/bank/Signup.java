package bank;



import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JLabel l9;
    JLabel l10;
    JLabel l11;
    JLabel l12;
    JLabel l13;
    JLabel l14;
    JLabel l15;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton r3;
    JRadioButton r4;
    JRadioButton r5;
    JButton b;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4;
    String first;

    Signup() {
    
    	    Random rand = new Random();
    	    long randNum = rand.nextLong() % 9000 + 1000;
    	    String number = "" + Math.abs(randNum);
    	    this.first = number;

    	   
        this.l1 = new JLabel("APPLICATION FORM NO. " + this.first);
        
        this.l1.setFont(new Font("Raleway", 1, 38));
        this.l2 = new JLabel("Page 1: Personal Details");
        this.l2.setFont(new Font("Raleway", 1, 22));
        this.l3 = new JLabel("Name:");
        this.l3.setFont(new Font("Raleway", 1, 20));
        this.l4 = new JLabel("Father's Name:");
        this.l4.setFont(new Font("Raleway", 1, 20));
        this.l5 = new JLabel("Date of Birth:");
        this.l5.setFont(new Font("Raleway", 1, 20));
        this.l6 = new JLabel("Gender:");
        this.l6.setFont(new Font("Raleway", 1, 20));
        this.l7 = new JLabel("Email Address:");
        this.l7.setFont(new Font("Raleway", 1, 20));
        this.l8 = new JLabel("Marital Status:");
        this.l8.setFont(new Font("Raleway", 1, 20));
        this.l9 = new JLabel("Address:");
        this.l9.setFont(new Font("Raleway", 1, 20));
        this.l10 = new JLabel("City:");
        this.l10.setFont(new Font("Raleway", 1, 20));
        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", 1, 20));
        this.l12 = new JLabel("State:");
        this.l12.setFont(new Font("Raleway", 1, 20));
        this.l13 = new JLabel("Date");
        this.l13.setFont(new Font("Raleway", 1, 14));
        this.l14 = new JLabel("Month");
        this.l14.setFont(new Font("Raleway", 1, 14));
        this.l15 = new JLabel("Year");
        this.l15.setFont(new Font("Raleway", 1, 14));
        this.t1 = new JTextField();
        this.t1.setFont(new Font("Raleway", 1, 14));
        this.t2 = new JTextField();
        this.t2.setFont(new Font("Raleway", 1, 14));
        this.t3 = new JTextField();
        this.t3.setFont(new Font("Raleway", 1, 14));
        this.t4 = new JTextField();
        this.t4.setFont(new Font("Raleway", 1, 14));
        this.t5 = new JTextField();
        this.t5.setFont(new Font("Raleway", 1, 14));
        this.t6 = new JTextField();
        this.t6.setFont(new Font("Raleway", 1, 14));
        this.t7 = new JTextField();
        this.t7.setFont(new Font("Raleway", 1, 14));
        this.b = new JButton("Next");
        this.b.setFont(new Font("Raleway", 1, 14));
        this.b.setBackground(Color.BLACK);
        this.b.setForeground(Color.BLACK);
        this.r1 = new JRadioButton("Male");
        this.r1.setFont(new Font("Raleway", 1, 10));
        this.r1.setBackground(Color.WHITE);
        this.r2 = new JRadioButton("Female");
        this.r2.setFont(new Font("Raleway", 1, 14));
        this.r2.setBackground(Color.WHITE);
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(this.r1);
        groupgender.add(this.r2);
        this.r3 = new JRadioButton("Married");
        this.r3.setFont(new Font("Raleway", 1, 12));
        this.r3.setBackground(Color.WHITE);
        this.r4 = new JRadioButton("Unmarried");
        this.r4.setFont(new Font("Raleway", 1, 12));
        this.r4.setBackground(Color.WHITE);
        this.r5 = new JRadioButton("Other");
        this.r5.setFont(new Font("Raleway", 1, 14));
        this.r5.setBackground(Color.WHITE);
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(this.r3);
        groupstatus.add(this.r4);
        groupstatus.add(this.r5);
        this.dateChooser = new JDateChooser();
        this.dateChooser.setForeground(new Color(105, 105, 105));
        this.dateChooser.setBounds(137, 337, 200, 29);
        this.add(this.dateChooser);
        this.setLayout((LayoutManager)null);
        this.l1.setBounds(140, 20, 600, 40);
        this.add(this.l1);
        this.l2.setBounds(290, 80, 600, 30);
        this.add(this.l2);
        this.l3.setBounds(100, 140, 100, 30);
        this.add(this.l3);
        this.t1.setBounds(300, 140, 400, 30);
        this.add(this.t1);
        this.l4.setBounds(100, 190, 200, 30);
        this.add(this.l4);
        this.t2.setBounds(300, 190, 400, 30);
        this.add(this.t2);
        this.l5.setBounds(100, 240, 200, 30);
        this.add(this.l5);
        this.dateChooser.setBounds(300, 240, 400, 30);
        this.l6.setBounds(100, 290, 200, 30);
        this.add(this.l6);
        this.r1.setBounds(300, 290, 60, 30);
        this.add(this.r1);
        this.r2.setBounds(450, 290, 90, 30);
        this.add(this.r2);
        this.l7.setBounds(100, 340, 200, 30);
        this.add(this.l7);
        this.t3.setBounds(300, 340, 400, 30);
        this.add(this.t3);
        this.l8.setBounds(100, 390, 200, 30);
        this.add(this.l8);
        this.r3.setBounds(300, 390, 100, 30);
        this.add(this.r3);
        this.r4.setBounds(450, 390, 100, 30);
        this.add(this.r4);
        this.r5.setBounds(635, 390, 100, 30);
        this.add(this.r5);
        this.l9.setBounds(100, 440, 200, 30);
        this.add(this.l9);
        this.t4.setBounds(300, 440, 400, 30);
        this.add(this.t4);
        this.l10.setBounds(100, 490, 200, 30);
        this.add(this.l10);
        this.t5.setBounds(300, 490, 400, 30);
        this.add(this.t5);
        l11.setBounds(100, 540, 200, 30);
        this.add(l11);
        this.t6.setBounds(300, 540, 400, 30);
        this.add(this.t6);
        this.l12.setBounds(100, 590, 200, 30);
        this.add(this.l12);
        this.t7.setBounds(300, 590, 400, 30);
        this.add(this.t7);
        this.b.setBounds(620, 660, 80, 30);
        this.add(this.b);
        this.b.addActionListener(this);
        getContentPane().setBackground(new Color(240, 240, 240));
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(850, 800);
        this.setLocation(500, 120);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = this.first;
        String name = this.t1.getText();
        String fname = this.t2.getText();
        String dob = ((JTextField)this.dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (this.r1.isSelected()) {
            gender = "Male";
        } else if (this.r2.isSelected()) {
            gender = "Female";
        }

        String email = this.t3.getText();
        String marital = null;
        if (this.r3.isSelected()) {
            marital = "Married";
        } else if (this.r4.isSelected()) {
            marital = "Unmarried";
        } else if (this.r5.isSelected()) {
            marital = "Other";
        }

        String address = this.t4.getText();
        String city = this.t5.getText();
        String pincode = this.t6.getText();
        String state = this.t7.getText();

        try {
            if (this.t6.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Fill all the required fields");
            } else {
            	ConnectionFactory cf = new ConnectionFactory();
                String q1 = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                cf.stmt.executeUpdate(q1);
                
                // Open SignupTwo window
                SignupTwo signupTwo = new SignupTwo(q1);
                signupTwo.setVisible(true);
                
                this.setVisible(false);
            }
        } catch (Exception var15) {
            var15.printStackTrace();
        }
    }

    

    public static void main(String[] args) {
        (new Signup()).setVisible(true);
    }
}
