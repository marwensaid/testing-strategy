package com.orange.testingstrategycalculator;

public class Calculator {
    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Soustraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public int multiply(int a, int b) {
        return a * b;
    }

    // Division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }

    // Maximum entre deux nombres
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    // Minimum entre deux nombres
    public int min(int a, int b) {
        return Math.min(a, b);

}
}

