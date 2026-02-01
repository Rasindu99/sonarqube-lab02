package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.sql.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    void testFindUser_Success() throws Exception {
        try (MockedStatic<DriverManager> mockedDriverManager = mockStatic(DriverManager.class)) {
            Connection mockConn = mock(Connection.class);
            PreparedStatement mockPstmt = mock(PreparedStatement.class);
            ResultSet mockRs = mock(ResultSet.class);

            mockedDriverManager.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                               .thenReturn(mockConn);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockPstmt);
            when(mockPstmt.executeQuery()).thenReturn(mockRs);
            when(mockRs.next()).thenReturn(true);
            when(mockRs.getString("name")).thenReturn("admin");

            assertDoesNotThrow(() -> userService.findUser("admin"));
        }
    }

    @Test
    void testDeleteUser_Success() throws Exception {
        try (MockedStatic<DriverManager> mockedDriverManager = mockStatic(DriverManager.class)) {
            Connection mockConn = mock(Connection.class);
            PreparedStatement mockPstmt = mock(PreparedStatement.class);

            mockedDriverManager.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString()))
                               .thenReturn(mockConn);
            when(mockConn.prepareStatement(anyString())).thenReturn(mockPstmt);

            assertDoesNotThrow(() -> userService.deleteUser("admin"));
        }
    }
}