package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
        "10, 5, add, 15",
        "10, 5, add-again, 15",
        "10, 5, sub, 5",
        "10, 5, sub-again, 5",
        "10, 5, mul, 50",
        "10, 2, div, 5",
        "10, 0, div, 0",
        "10, 3, mod, 1",
        "2, 3, pow, 8",
        "10, 5, unknown, 0"
    })
    void testCalculate(int a, int b, String op, int expected) {
        assertEquals(expected, calculator.calculate(a, b, op));
    }

    @Test
    void testCalculate_NullOp() {
        assertEquals(0, calculator.calculate(10, 5, null));
    }
}