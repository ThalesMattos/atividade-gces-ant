package com.demo;

import java.util.Scanner;

/**
 * Ponto de entrada da aplicação demonstrativa do Apache Ant.
 *
 * <p>O Ant empacota esta classe como {@code Main-Class} no manifesto do JAR,
 * tornando o artefato final diretamente executável:</p>
 * <pre>
 *   java -jar dist/ant-demo.jar
 * </pre>
 *
 * @author  Seminário Ant Build Tool
 * @version 1.0.0
 * @see     Calculator
 * @see     StringUtils
 */
public class Main {

    /** Construtor privado — classe utilitária com método main estático. */
    private Main() {}

    /**
     * Ponto de entrada da JVM.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Demonstração Ant Build Tool ===\n");

        // --- Calculadora ---
        Calculator calc = new Calculator();
        System.out.println(">> Calculadora");
        System.out.print("   Digite o primeiro número inteiro : ");
        int a = scanner.nextInt();
        System.out.print("   Digite o segundo número inteiro  : ");
        int b = scanner.nextInt();

        System.out.println();
        System.out.println("   " + a + " + " + b + " = " + calc.add(a, b));
        System.out.println("   " + a + " - " + b + " = " + calc.subtract(a, b));
        System.out.println("   " + a + " × " + b + " = " + calc.multiply(a, b));
        if (b != 0) {
            System.out.printf("   %d ÷ %d = %.2f%n", a, b, calc.divide(a, b));
        } else {
            System.out.println("   Divisão ignorada: segundo número é zero.");
        }

        // --- StringUtils ---
        StringUtils utils = new StringUtils();
        scanner.nextLine(); // consumir quebra de linha pendente
        System.out.println("\n>> StringUtils");
        System.out.print("   Digite uma palavra para capitalizar      : ");
        String word = scanner.nextLine().trim();
        System.out.print("   Quantas vezes deseja repeti-la?          : ");
        int times = scanner.nextInt();
        scanner.nextLine();
        System.out.print("   Digite uma frase para testar palíndromo  : ");
        String phrase = scanner.nextLine().trim();

        System.out.println();
        System.out.println("   capitalize(\"" + word + "\")          = " + utils.capitalize(word));
        System.out.println("   repeat(\"" + word + "\", " + times + ")           = " + utils.repeat(word, times));
        System.out.println("   isPalindrome(\"" + phrase + "\") = " + utils.isPalindrome(phrase));

        System.out.println("\nBuild realizado com Apache Ant!");
        scanner.close();
    }
}
