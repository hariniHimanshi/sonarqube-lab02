package com.example;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testFindUser() throws Exception {
        // 1. Create Mocks
        Connection mockConn = mock(Connection.class);
        PreparedStatement mockPs = mock(PreparedStatement.class);
        ResultSet mockRs = mock(ResultSet.class);

        // 2. Define behavior
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPs);
        when(mockPs.executeQuery()).thenReturn(mockRs);

        // ✅ FIX: Return true first (found user), then false (stop loop)
        when(mockRs.next()).thenReturn(true).thenReturn(false);
        
        when(mockRs.getString("name")).thenReturn("TestUser");

        // 3. Spy on UserService
        UserService service = spy(new UserService());
        doReturn(mockConn).when(service).getConnection();

        // 4. Run the method
        service.findUser("TestUser");

        // 5. Verify
        verify(mockPs).setString(1, "TestUser");
    }
}