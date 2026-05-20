package com.demo;

/**
 * Realiza operações aritméticas básicas.
 *
 * <p>Esta classe é compilada pelo Apache Ant via a task {@code <javac>}
 * e empacotada no artefato final {@code ant-demo.jar} pela task {@code <jar>}.</p>
 *
 * @author  Seminário Ant Build Tool
 * @version 1.0.0
 */
public class Calculator {

    /** Cria uma instância de {@code Calculator}. */
    public Calculator() {}

    /**
     * Retorna a soma de dois inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return {@code a + b}
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Retorna a diferença entre dois inteiros.
     *
     * @param a minuendo
     * @param b subtraendo
     * @return {@code a - b}
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Retorna o produto de dois inteiros.
     *
     * @param a multiplicando
     * @param b multiplicador
     * @return {@code a * b}
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Retorna o quociente da divisão de {@code a} por {@code b}.
     *
     * @param a dividendo
     * @param b divisor (não pode ser zero)
     * @return {@code a / b} como número de ponto flutuante
     * @throws ArithmeticException se {@code b} for igual a zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        return (double) a / b;
    }
}
