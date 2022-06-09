package com.anusoft.unittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ArraysCompareTest {

    @Test
    public void test_ArraysSort_randomArray_positive() {
        int[] actual = {3, 4, 1, 2};
        int[] expected = {1, 2, 3, 4};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_ArraysSort_randomArray_negative() {
        int[] actual = {3, 4, 1, 2};
        int[] expected = {1, 3, 2, 4};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    /*
    * In this method we are passing null array which will throw an error
    * Hence, we are asserting NullPointerException
    *
    * */
    @Test
    public void test_ArraysSort_nullArray() {
        int[] actual = null;
        int[] expected = {1, 3, 2, 4};
        assertThrows(NullPointerException.class, () -> {
            Arrays.sort(actual);
            assertArrayEquals(expected, actual);
        });
    }

    /*
     * In this test case we have set timeout as 100ms
     * Hence, when the test case execution takes more than 100ms it will fail
     * if it takes less than 100ms then all is fine and green ;)
     *
     * */
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void test_ArraysSort_performance() {
        int[] array = {3, 4, 1, 2};

        for (int i = 0; i < 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
