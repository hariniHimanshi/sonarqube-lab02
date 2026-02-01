package com.example;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testFindUserSuccess() throws Exception {
        // Happy Path: Database works
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockPs = mock(PreparedStatement.class);
        ResultSet mockRs = mock(ResultSet.class);

        when(mockConn.prepareStatement(anyString())).thenReturn(mockPs);
        when(mockPs.executeQuery()).thenReturn(mockRs);
        when(mockRs.next()).thenReturn(true).thenReturn(false); // Loop once
        when(mockRs.getString("name")).thenReturn("TestUser");

        UserService service = spy(new UserService());
        doReturn(mockConn).when(service).getConnection();

        service.findUser("TestUser");

        verify(mockPs).setString(1, "TestUser");
    }

    @Test
    void testFindUserDatabaseError() throws Exception {
        // Error Path: Simulate a DB failure to cover the 'catch' block
        Connection mockConn = mock(Connection.class);
        
        // Force the code to throw an error when preparing statement
        when(mockConn.prepareStatement(anyString())).thenThrow(new SQLException("Connection Failed"));

        UserService service = spy(new UserService());
        doReturn(mockConn).when(service).getConnection();

        // This method should catch the exception internally and NOT crash
        service.findUser("TestUser");

        // Verify we tried to access DB, even though it failed
        verify(mockConn).prepareStatement(anyString());
    }
}