package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    // You must define the password variable or pass it in
    private String password = "your_password_here"; 

    public void findUser(String username) throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);

        // FIX: Use a placeholder (?) instead of concatenating the string
        String query = "SELECT * FROM users WHERE name = ?";

        // FIX: Use PreparedStatement to safely inject the username
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);

        pstmt.executeQuery();
        
        // Good practice: close connections
        pstmt.close();
        conn.close();
    }
}