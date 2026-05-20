package com.demo;

/**
 * Utilitários para manipulação de strings.
 *
 * <p>Segundo módulo do projeto, demonstrando que o Apache Ant
 * resolve e compila múltiplas classes com dependências entre si.</p>
 *
 * @author  Seminário Ant Build Tool
 * @version 1.0.0
 */
public class StringUtils {

    /** Cria uma instância de {@code StringUtils}. */
    public StringUtils() {}

    /**
     * Capitaliza a primeira letra e converte o restante para minúsculas.
     *
     * @param text texto de entrada
     * @return texto capitalizado, ou o próprio valor se nulo/vazio
     */
    public String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }

    /**
     * Repete uma string um determinado número de vezes.
     *
     * @param text  texto a repetir
     * @param times número de repetições (0 retorna string vazia)
     * @return concatenação de {@code times} cópias de {@code text}
     */
    public String repeat(String text, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

    /**
     * Verifica se um texto é um palíndromo (ignora maiúsculas e espaços).
     *
     * @param text texto a verificar
     * @return {@code true} se o texto for igual ao seu reverso
     */
    public boolean isPalindrome(String text) {
        String clean = text.toLowerCase().replaceAll("\\s+", "");
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }
}
