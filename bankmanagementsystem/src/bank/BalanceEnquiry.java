package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {
    private JLabel balanceLabel;
    private JButton backButton;

    private String currentPin;

    public BalanceEnquiry(String currentPin) {
        this.currentPin = currentPin;

        setTitle("Balance Enquiry");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(52, 152, 219)); // Background color

        balanceLabel = new JLabel();
        updateBalance();
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel, BorderLayout.CENTER);

        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(this);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateBalance() {
        try {
            ConnectionFactory cf = new ConnectionFactory();
            ResultSet rs = cf.stmt.executeQuery("SELECT SUM(amount) AS total_amount FROM bank WHERE pin = '" + currentPin + "'");
            if (rs.next()) {
                int totalAmount = rs.getInt("total_amount");
                balanceLabel.setText("Remaining Balance: " + totalAmount);
            } else {
                balanceLabel.setText("No transactions yet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new Transactions(currentPin).setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
