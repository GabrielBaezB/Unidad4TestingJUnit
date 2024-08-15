package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdvancedCalculatorTest {

    private final AdvancedCalculator advancedCalculator = new AdvancedCalculator();

    // Pruebas para el método multiply
    @Test
    void testMultiplyPositiveNumbers() {
        int result = advancedCalculator.multiply(4, 5);
        assertEquals(20, result, "4 * 5 should equal 20");
    }

    @Test
    void testMultiplyByZero() {
        int result = advancedCalculator.multiply(4, 0);
        assertEquals(0, result, "4 * 0 should equal 0");
    }

    @Test
    void testMultiplyNegativeNumbers() {
        int result = advancedCalculator.multiply(-4, -5);
        assertEquals(20, result, "-4 * -5 should equal 20");
    }

    @Test
    void testMultiplyPositiveAndNegativeNumber() {
        int result = advancedCalculator.multiply(4, -5);
        assertEquals(-20, result, "4 * -5 should equal -20");
    }

    // Pruebas para el método divide
    @Test
    void testDividePositiveNumbers() {
        int result = advancedCalculator.divide(20, 4);
        assertEquals(5, result, "20 / 4 should equal 5");
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            advancedCalculator.divide(20, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testDivideNegativeNumbers() {
        int result = advancedCalculator.divide(-20, -4);
        assertEquals(5, result, "-20 / -4 should equal 5");
    }

    @Test
    void testDividePositiveAndNegativeNumber() {
        int result = advancedCalculator.divide(20, -4);
        assertEquals(-5, result, "20 / -4 should equal -5");
    }
}
