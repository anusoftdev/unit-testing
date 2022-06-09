package com.anusoft.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
*
* Here we will test the List interface
*
* */
public class ListTest {

    @Test
    public void test_mock_list_size() {
        // mock the list object
        List listMock = mock(List.class);

        //stub the size() method call
        when(listMock.size()).thenReturn(2);

        //assert the result
        assertEquals(2, listMock.size());
    }

    @Test
    public void test_mock_list_size_return_multiple_values() {
        // mock the list object
        List listMock = mock(List.class);

        //stub the size() method call
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);

        //assert the result
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(4, listMock.size());
    }

    @Test
    public void test_mock_list_get() {
        // mock the list object
        List listMock = mock(List.class);

        //stub the size() method call
        when(listMock.get(0)).thenReturn(6);

        //assert the result
        assertEquals(6, listMock.get(0));
    }

    @Test
    public void test_mock_list_get_any_value() {
        // mock the list object
        List listMock = mock(List.class);

        //anyInt is called Matchers
        when(listMock.get(anyInt())).thenReturn("Any Integer");

        //assert the result
        assertEquals("Any Integer", listMock.get(0));
        assertEquals("Any Integer", listMock.get(7));
    }
}
