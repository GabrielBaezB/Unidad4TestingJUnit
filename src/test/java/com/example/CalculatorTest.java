package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // Pruebas para el método add
    @Test
    void testAddPositiveNumbers() {
        int result = calculator.add(10, 5);
        assertEquals(15, result, "10 + 5 should equal 15");
    }

    @Test
    void testAddPositiveAndNegativeNumber() {
        int result = calculator.add(10, -5);
        assertEquals(5, result, "10 + (-5) should equal 5");
    }

    @Test
    void testAddNegativeNumbers() {
        int result = calculator.add(-10, -5);
        assertEquals(-15, result, "-10 + (-5) should equal -15");
    }

    @Test
    void testAddPositiveNumberAndZero() {
        int result = calculator.add(10, 0);
        assertEquals(10, result, "10 + 0 should equal 10");
    }

    @Test
    void testAddLargeNumbers() {
        int result = calculator.add(1_000_000, 2_000_000);
        assertEquals(3_000_000, result, "1,000,000 + 2,000,000 should equal 3,000,000");
    }

    // Pruebas para el método subtract
    @Test
    void testSubtractPositiveNumbers() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should equal 5");
    }

    @Test
    void testSubtractPositiveAndNegativeNumber() {
        int result = calculator.subtract(10, -5);
        assertEquals(15, result, "10 - (-5) should equal 15");
    }

    @Test
    void testSubtractNegativeNumbers() {
        int result = calculator.subtract(-10, -5);
        assertEquals(-5, result, "-10 - (-5) should equal -5");
    }

    @Test
    void testSubtractPositiveNumberByZero() {
        int result = calculator.subtract(10, 0);
        assertEquals(10, result, "10 - 0 should equal 10");
    }

    @Test
    void testSubtractLargeNumbers() {
        int result = calculator.subtract(2_000_000, 1_000_000);
        assertEquals(1_000_000, result, "2,000,000 - 1,000,000 should equal 1,000,000");
    }
}
