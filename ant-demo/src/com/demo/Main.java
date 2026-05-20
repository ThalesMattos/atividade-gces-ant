package com.demo;

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
        System.out.println("=== Demonstração Ant Build Tool ===\n");

        // --- Calculadora ---
        Calculator calc = new Calculator();
        System.out.println(">> Calculadora:");
        System.out.println("   150 + 75  = " + calc.add(150, 75));
        System.out.println("   200 - 50  = " + calc.subtract(200, 50));
        System.out.println("   12  × 8   = " + calc.multiply(12, 8));
        System.out.printf("   100 ÷ 4   = %.1f%n", calc.divide(100, 4));

        // --- StringUtils ---
        StringUtils utils = new StringUtils();
        System.out.println("\n>> StringUtils:");
        System.out.println("   capitalize('ant')      = " + utils.capitalize("ant"));
        System.out.println("   repeat('build-', 3)    = " + utils.repeat("build-", 3));
        System.out.println("   isPalindrome('arara')  = " + utils.isPalindrome("arara"));
        System.out.println("   isPalindrome('java')   = " + utils.isPalindrome("java"));

        System.out.println("\nBuild realizado com Apache Ant!");
    }
}
