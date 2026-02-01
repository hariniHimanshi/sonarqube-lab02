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
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.calculate(10, 5, "div"));
    }

    @Test
    void testDivideByZero() {
        assertEquals(0, calc.calculate(10, 0, "div"));
    }

    @Test
    void testModulo() {
        assertEquals(1, calc.calculate(10, 3, "mod"));
    }

    @Test
    void testPower() {
        assertEquals(8, calc.calculate(2, 3, "pow"));
    }

    @Test
    void testUnknownOperation() {
        assertEquals(0, calc.calculate(10, 5, "unknown"));
    }
}