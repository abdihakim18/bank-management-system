//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bank;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {
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
    JButton b;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton r3;
    JRadioButton r4;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JComboBox c1;
    JComboBox c2;
    JComboBox c3;
    JComboBox c4;
    JComboBox c5;
    String formno;

    SignupTwo(String formno) {
        
        this.formno = formno;
        this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        this.l1 = new JLabel("Page 2: Additonal Details");
        this.l1.setFont(new Font("Raleway", 1, 22));
        this.l2 = new JLabel("Religion:");
        this.l2.setFont(new Font("Raleway", 1, 18));
        this.l3 = new JLabel("Category:");
        this.l3.setFont(new Font("Raleway", 1, 18));
        this.l4 = new JLabel("Income:");
        this.l4.setFont(new Font("Raleway", 1, 18));
        this.l5 = new JLabel("Educational");
        this.l5.setFont(new Font("Raleway", 1, 18));
        this.l11 = new JLabel("Qualification:");
        this.l11.setFont(new Font("Raleway", 1, 18));
        this.l6 = new JLabel("Occupation:");
        this.l6.setFont(new Font("Raleway", 1, 18));
        this.l7 = new JLabel("PAN Number:");
        this.l7.setFont(new Font("Raleway", 1, 18));
        this.l8 = new JLabel("Aadhar Number:");
        this.l8.setFont(new Font("Raleway", 1, 18));
        this.l9 = new JLabel("Senior Citizen:");
        this.l9.setFont(new Font("Raleway", 1, 18));
        this.l10 = new JLabel("Existing Account:");
        this.l10.setFont(new Font("Raleway", 1, 18));
        this.l12 = new JLabel("Form No:");
        this.l12.setFont(new Font("Raleway", 1, 13));
        this.l13 = new JLabel(formno);
        this.l13.setFont(new Font("Raleway", 1, 13));
        this.b = new JButton("Next");
        this.b.setFont(new Font("Raleway", 1, 14));
        this.b.setBackground(Color.BLACK);
        this.b.setForeground(Color.BLACK);
        this.t1 = new JTextField();
        this.t1.setFont(new Font("Raleway", 1, 14));
        this.t2 = new JTextField();
        this.t2.setFont(new Font("Raleway", 1, 14));
        this.r1 = new JRadioButton("Yes");
        this.r1.setFont(new Font("Raleway", 1, 14));
        this.r1.setBackground(Color.WHITE);
        this.r2 = new JRadioButton("No");
        this.r2.setFont(new Font("Raleway", 1, 14));
        this.r2.setBackground(Color.WHITE);
        this.r3 = new JRadioButton("Yes");
        this.r3.setFont(new Font("Raleway", 1, 14));
        this.r3.setBackground(Color.WHITE);
        this.r4 = new JRadioButton("No");
        this.r4.setFont(new Font("Raleway", 1, 14));
        this.r4.setBackground(Color.WHITE);
        String[] religion = new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        this.c1 = new JComboBox(religion);
        this.c1.setBackground(Color.WHITE);
        this.c1.setFont(new Font("Raleway", 1, 14));
        String[] category = new String[]{"General", "OBC", "SC", "ST", "Other"};
        this.c2 = new JComboBox(category);
        this.c2.setBackground(Color.WHITE);
        this.c2.setFont(new Font("Raleway", 1, 14));
        String[] income = new String[]{"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        this.c3 = new JComboBox(income);
        this.c3.setBackground(Color.WHITE);
        this.c3.setFont(new Font("Raleway", 1, 14));
        String[] education = new String[]{"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        this.c4 = new JComboBox(education);
        this.c4.setBackground(Color.WHITE);
        this.c4.setFont(new Font("Raleway", 1, 14));
        String[] occupation = new String[]{"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};
        this.c5 = new JComboBox(occupation);
        this.c5.setBackground(Color.WHITE);
        this.c5.setFont(new Font("Raleway", 1, 14));
        this.setLayout((LayoutManager)null);
        this.l12.setBounds(700, 10, 60, 30);
        this.add(this.l12);
        this.l13.setBounds(760, 10, 60, 30);
        this.add(this.l13);
        this.l1.setBounds(280, 30, 600, 40);
        this.add(this.l1);
        this.l2.setBounds(100, 120, 100, 30);
        this.add(this.l2);
        this.c1.setBounds(350, 120, 320, 30);
        this.add(this.c1);
        this.l3.setBounds(100, 170, 100, 30);
        this.add(this.l3);
        this.c2.setBounds(350, 170, 320, 30);
        this.add(this.c2);
        this.l4.setBounds(100, 220, 100, 30);
        this.add(this.l4);
        this.c3.setBounds(350, 220, 320, 30);
        this.add(this.c3);
        this.l5.setBounds(100, 270, 150, 30);
        this.add(this.l5);
        this.c4.setBounds(350, 270, 320, 30);
        this.add(this.c4);
        this.l11.setBounds(100, 290, 150, 30);
        this.add(this.l11);
        this.l6.setBounds(100, 340, 150, 30);
        this.add(this.l6);
        this.c5.setBounds(350, 340, 320, 30);
        this.add(this.c5);
        this.l7.setBounds(100, 390, 150, 30);
        this.add(this.l7);
        this.t1.setBounds(350, 390, 320, 30);
        this.add(this.t1);
        this.l8.setBounds(100, 440, 180, 30);
        this.add(this.l8);
        this.t2.setBounds(350, 440, 320, 30);
        this.add(this.t2);
        this.l9.setBounds(100, 490, 150, 30);
        this.add(this.l9);
        this.r1.setBounds(350, 490, 100, 30);
        this.add(this.r1);
        this.r2.setBounds(460, 490, 100, 30);
        this.add(this.r2);
        this.l10.setBounds(100, 540, 180, 30);
        this.add(this.l10);
        this.r3.setBounds(350, 540, 100, 30);
        this.add(this.r3);
        this.r4.setBounds(460, 540, 100, 30);
        this.add(this.r4);
        this.b.setBounds(570, 640, 100, 30);
        this.add(this.b);
        this.b.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(850, 750);
        this.setLocation(500, 120);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String)this.c1.getSelectedItem();
        String category = (String)this.c2.getSelectedItem();
        String income = (String)this.c3.getSelectedItem();
        String education = (String)this.c4.getSelectedItem();
        String occupation = (String)this.c5.getSelectedItem();
        String pan = this.t1.getText();
        String aadhar = this.t2.getText();
        String scitizen = "";
        if (this.r1.isSelected()) {
            scitizen = "Yes";
        } else if (this.r2.isSelected()) {
            scitizen = "No";
        }

        String eaccount = "";
        if (this.r3.isSelected()) {
            eaccount = "Yes";
        } else if (this.r4.isSelected()) {
            eaccount = "No";
        }

        try {
            if (this.t2.getText().equals("")) {
                JOptionPane.showMessageDialog((Component)null, "Fill all the required fields");
            } else {
                ;
               
                String q1 = "insert into signuptwo values('" + this.formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "')";

                ConnectionFactory cf = new ConnectionFactory();
                cf.stmt.executeUpdate(q1);
                (new SignupThree(this.formno)).setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception var13) {
            var13.printStackTrace();
        }

    }

    public static void main(String[] args) {
        (new SignupTwo("")).setVisible(true);
    }
}
