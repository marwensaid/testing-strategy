package com.orange.testingstrategycalculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadCalculatorTest {

    Calculator calculator = new Calculator();
    Map<Integer, String> database = new HashMap<>();

    // Test trop complexe + redondant
    @Test
    void testEverything() {
        int a = 5;
        int b = 3;
        int sum = calculator.add(a, b);
        int diff = calculator.subtract(a, b);
        int prod = calculator.multiply(a, b);
        int div = calculator.divide(a, b);
        assertEquals(8, sum);
        assertEquals(2, diff);
        assertEquals(15, prod);
        assertEquals(1, div);
    }

    // Test dépendant de l’environnement
    @Test
    void testDatabase() {
        database.put(1, "Alice");
        String name = database.get(1);
        assertEquals("Alice", name);
    }

    // Test non lisible
    @Test
    void t1() {
        int r = calculator.add(2,3);
        assertEquals(5, r);
    }

    // Test fragile (dépend d’une liste modifiable)
    @Test
    void testFragile() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int sum = calculator.add(list.get(0), list.get(1));
        assertEquals(3, sum);
        list.clear();
    }

    // Test inutile (ne fait aucune assertion pertinente)
    @Test
    void testUseless() {
        calculator.multiply(3, 4);
    }
}
