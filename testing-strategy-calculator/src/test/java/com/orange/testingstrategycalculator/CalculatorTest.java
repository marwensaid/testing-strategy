package com.orange.testingstrategycalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {


    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        int a = 5;
        int b = 3;
        int result = calculator.add(a, b);
        assertEquals(8, result, "5 + 3 devrait être égal à 8");
    }

    @Test
    void testSubtraction() {
        int a = 10;
        int b = 4;
        int result = calculator.subtract(a, b);
        assertEquals(6, result, "10 - 4 devrait être égal à 6");
    }

    @Test
    void testMultiplication() {
        int a = 7;
        int b = 6;
        int result = calculator.multiply(a, b);
        assertEquals(42, result, "7 * 6 devrait être égal à 42");
    }

    @Test
    void testDivision() {
        int a = 20;
        int b = 5;
        int result = calculator.divide(a, b);
        assertEquals(4, result, "20 / 5 devrait être égal à 4");
    }

    @Test
    void testDivisionParZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division par zéro impossible", exception.getMessage());
    }

    @Test
    void testMax() {
        assertEquals(10, calculator.max(10, 5));
        assertEquals(7, calculator.max(3, 7));
    }

    @Test
    void testMin() {
        assertEquals(2, calculator.min(2, 5));
        assertEquals(-1, calculator.min(3, -1));
    }

    @Test
    void testCasLimitesAddition() {
        int result = calculator.add(Integer.MAX_VALUE, 1);
        assertTrue(result < 0, "Résultat devrait provoquer un overflow");
    }

    @Test
    void testCasLimitesSubtraction() {
        int result = calculator.subtract(Integer.MIN_VALUE, 1);
        assertTrue(result > 0, "Résultat devrait provoquer un overflow");
    }

}
