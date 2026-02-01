package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMain() {
        // This executes the logic in App.java and covers the lines
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}