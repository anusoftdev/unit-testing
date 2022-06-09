package com.anusoft.unittesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperUtilTest {

    StringHelperUtil stringHelperUtil = new StringHelperUtil();

    /*
    * This annotation is used when we want to run or initialize something
    * before all test when class is loaded.
    *
    * Method annotated with @BeforeAll must be static.
    *
    * It is mostly used to make some initial connection like Database etc.
    *
    * */
    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Running test : ");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Completed!");
    }

    @Test
    public void test_countWordsInString() {
        System.out.println("test_countWordsInString");
        assertEquals(5, stringHelperUtil.countWordsInString("anu trip dada ji hi"));
    }

    @Test
    public void test_reverseString_basic() {
        System.out.println("test_reverseString_basic");
        assertEquals("garuna", stringHelperUtil.reverseString("anurag"));
    }

    @Test
    public void test_isPalindrome_positive() {
        System.out.println("test_isPalindrome_positive");
        assertTrue(stringHelperUtil.isPalindrome("naman"));
    }

    @Test
    public void test_isPalindrome_negative() {
        System.out.println("test_isPalindrome_negative");
        assertFalse(stringHelperUtil.isPalindrome("shiva"));
    }
}
