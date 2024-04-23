package bank;

import java.sql.*;

public class ConnectionFactory {
    private static Connection con;
    static Statement stmt;

    public ConnectionFactory() {
        try {
            // Loading The Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bankmanagement", "root", "NIVESHTYAGI");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static Statement getStatement() {
        return stmt;
    }
}
