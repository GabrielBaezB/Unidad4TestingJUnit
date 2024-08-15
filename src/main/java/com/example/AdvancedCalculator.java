package com.example;

public class AdvancedCalculator extends Calculator {

    // Método para multiplicar dos números
    public int multiply(int a, int b) {
        return a * b;
    }

    // Método para dividir dos números
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
