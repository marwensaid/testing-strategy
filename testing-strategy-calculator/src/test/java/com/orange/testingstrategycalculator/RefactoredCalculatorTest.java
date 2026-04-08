package com.orange.testingstrategycalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefactoredCalculatorTest {

    Calculator calculator = new Calculator();

    // --- Addition ---
    @Test
    void shouldReturnSumWhenAddingTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void shouldReturnSumWhenAddingNegativeAndPositive() {
        assertEquals(0, calculator.add(-3, 3));
    }

    @Test
    void shouldHandleOverflowOnAddition() {
        int result = calculator.add(Integer.MAX_VALUE, 1);
        assertTrue(result < 0, "Overflow attendu");
    }

    // --- Soustraction ---
    @Test
    void shouldReturnDifferenceWhenSubtractingTwoNumbers() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    void shouldHandleUnderflowOnSubtraction() {
        int result = calculator.subtract(Integer.MIN_VALUE, 1);
        assertTrue(result > 0, "Underflow attendu");
    }

    // --- Multiplication ---
    @Test
    void shouldReturnProductWhenMultiplyingTwoNumbers() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    // --- Division ---
    @Test
    void shouldReturnQuotientWhenDividingTwoNumbers() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division par zéro impossible", exception.getMessage());
    }

    // --- Max ---
    @Test
    void shouldReturnMaxValue() {
        assertEquals(7, calculator.max(3, 7));
        assertEquals(10, calculator.max(10, 5));
    }

    // --- Min ---
    @Test
    void shouldReturnMinValue() {
        assertEquals(-1, calculator.min(3, -1));
        assertEquals(2, calculator.min(2, 5));
    }


}
