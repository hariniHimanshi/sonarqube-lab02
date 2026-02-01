package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAppInstantiation() {
        // This covers the implicit "public App()" constructor
        App app = new App();
        assertNotNull(app);
    }
}
