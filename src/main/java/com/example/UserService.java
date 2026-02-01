package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    // 1. Initialize a Logger (Java Util Logging is built-in)
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    
    private static final String DB_URL = "jdbc:mysql://localhost/db";

    // 2. Removed 'throws Exception' from signature
    // Exceptions are now handled inside the method via try-catch.
    public void findUser(String username) {
        
        // 3. FIX: specific columns instead of SELECT *
        String query = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // 4. FIX: Use Logger instead of System.out
                    String foundName = rs.getString("name");
                    LOGGER.log(Level.INFO, "User found: {0}", foundName);
                }
            }
        } catch (SQLException e) {
            // Log the exception stack trace properly
            LOGGER.log(Level.SEVERE, "Database error occurred while finding user", e);
        }
    }

    protected Connection getConnection() throws SQLException {
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        if (dbUser == null || dbPassword == null) {
            // It is okay to throw specific RuntimeExceptions for configuration errors
            throw new IllegalStateException("DB credentials missing in environment variables.");
        }
        return DriverManager.getConnection(DB_URL, dbUser, dbPassword);
    }
    
    // Example Main method (Clean, no throws)
    public static void main(String[] args) {
        UserService service = new UserService();
        service.findUser("Alice");
    }
}