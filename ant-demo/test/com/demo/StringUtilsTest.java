package com.demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    private final StringUtils utils = new StringUtils();

    @Test
    public void testCapitalize() {
        assertEquals("Ant", utils.capitalize("ant"));
        assertEquals("Java", utils.capitalize("JAVA"));
    }

    @Test
    public void testRepeat() {
        assertEquals("build-build-build-", utils.repeat("build-", 3));
        assertEquals("", utils.repeat("x", 0));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(utils.isPalindrome("arara"));
        assertTrue(utils.isPalindrome("Ana"));
        assertFalse(utils.isPalindrome("java"));
    }
}
