package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    // FIX 1: Remove hardcoded credentials.
    // Ideally, inject a DataSource, but for standalone JDBC, read from env variables.
    private static final String DB_URL = "jdbc:mysql://localhost/db";

    public void findUser(String username) {
        String query = "SELECT * FROM users WHERE name = ?";

        // FIX 4: Use try-with-resources to ensure connections close (prevents memory leaks)
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // FIX 2: Prevent SQL Injection using parameters
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Process result set here
                    System.out.println("User found: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            // Handle exception properly (log it usually)
            e.printStackTrace();
        }
    }

    // Helper method to retrieve credentials securely
    private Connection getConnection() throws SQLException {
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");
        
        if (dbUser == null || dbPassword == null) {
            throw new IllegalStateException("Database credentials not set in environment.");
        }
        
        return DriverManager.getConnection(DB_URL, dbUser, dbPassword);
    }

    // FIX 3: 'notUsed' method removed completely.
}