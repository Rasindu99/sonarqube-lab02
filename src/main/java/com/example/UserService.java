package com.example;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    
    private String password = "admin123";
    private String dbUrl = "jdbc:mysql://localhost/db";
    private String dbUser = "root";

    public void findUser(String username) {
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LOGGER.log(Level.INFO, "User found: {0}", rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error finding user", e);
        }
    }

    public void deleteUser(String username) {
        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.execute();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting user", e);
        }
    }
}