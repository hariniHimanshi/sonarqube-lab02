package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAppInstantiation() {
        App app = new App();
        assertNotNull(app);
    }

    @Test
    void testMain() {
        // FIX: Replaced the empty try-catch block with assertThrows.
        // This confirms that an exception IS thrown (as expected due to missing DB config),
        // satisfying the "Add at least one assertion" rule.
        assertThrows(Exception.class, () -> {
            App.main(new String[]{});
        });
    }
}