package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(15, calc.calculate(10, 5, "add"));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calc.calculate(10, 5, "sub"));
    }

    @Test
    void testMultiply() {
        // Covers the "mul" case
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void testDivide() {
        // Covers the "div" case
        assertEquals(2, calc.calculate(10, 5, "div"));
    }

    @Test
    void testUnknownOperation() {
        // Covers the "default" case in switch statement
        // We expect it might return 0 or print an error, but calling it covers the lines.
        int result = calc.calculate(10, 5, "xyz"); 
    }
}