package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        // This tests the "add" operation
        int result = calc.calculate(10, 5, "add");
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        Calculator calc = new Calculator();
        // This tests the "sub" operation (adjust "sub" to match your code, e.g. "subtract" or "minus")
        int result = calc.calculate(10, 5, "sub"); 
        assertEquals(5, result);
    }
    
    // If your Calculator has other cases (multiply, divide), add them here!
}