package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws Exception {

        Connection conn =
            DriverManager.getConnection("jdbc:mysql://localhost/db",
                    "root", password);

        Statement st = conn.createStatement();

        String query =
            "SELECT * FROM users WHERE name = '" + username + "'";

        st.executeQuery(query);
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    // EVEN WORSE: another SQL injection
public void deleteUser(String username) throws SQLException {

    String sql = "DELETE FROM users WHERE name = ?";

    try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", "password");
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.executeUpdate();
    }
}

}
