package com.demo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários com JUnit 4.
 * O Ant executa estes testes automaticamente no target "test"
 * usando a task <junit> e gera relatório XML em build/test-reports/.
 */
public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(225, calc.add(150, 75));
    }

    @Test
    public void testSubtract() {
        assertEquals(150, calc.subtract(200, 50));
    }

    @Test
    public void testMultiply() {
        assertEquals(96, calc.multiply(12, 8));
    }

    @Test
    public void testDivide() {
        assertEquals(25.0, calc.divide(100, 4), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }
}
