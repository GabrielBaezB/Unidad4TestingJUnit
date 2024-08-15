package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// Indica que esta clase es una suite de pruebas
@Suite
@SelectClasses({
    CalculatorTest.class, // Incluye las clases de prueba que deseas en la suite
    AdvancedCalculatorTest.class // Incluye también AdvancedCalculatorTest
})
public class CalculatorTestSuite {
    // La clase CalculatorTestSuite simplemente sirve para agrupar las pruebas
}
