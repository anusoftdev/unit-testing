package com.anusoft.mathapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.InOrderImpl;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @Mock
    CalculatorService calculatorService;

    @InjectMocks
    MathApplication mathApplication;

    @Test
    public void test_add() {

        // adding behaviour to add method of calculatorService
        when(calculatorService.add(30.0, 20.0)).thenReturn(50.0);

        // asserting the expected and actual result
        assertEquals(mathApplication.add(30.0, 20.0), 50.0);

        // verifying the behaviour whether add method is called or not and how many times.
        verify(calculatorService, times(1)).add(30.0, 20.0);

        // verifying that method add with args 10, 20 is never called
        verify(calculatorService, never()).add(10.0,20.0);

        //check a minimum 1 call count
        verify(calculatorService, atLeastOnce()).add(30.0, 20.0);

        //check if add function is called minimum 2 times
        verify(calculatorService, atLeast(1)).add(30.0, 20.0);

        //check if add function is called maximum 3 times
        verify(calculatorService, atMost(3)).add(30.0, 20.0);
    }

    @Test
    public void test_add_with_exception() {

        //add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented"))
                .when(calculatorService).add(10.0,20.0);

        //test the add functionality
        assertThrows(RuntimeException.class, () -> {
            //assertEquals(mathApplication.add(10.0, 20.0),30.0,0); //this will also work.
            mathApplication.add(10.0, 20.0);
        });
    }

    @Test
    public void test_add_subtract_inorder() {

        // adding behaviour to add method of calculatorService
        when(calculatorService.add(30.0, 20.0)).thenReturn(50.0);
        when(calculatorService.subtract(30.0, 20.0)).thenReturn(10.0);

        // asserting the expected and actual result
        assertEquals(mathApplication.add(30.0, 20.0), 50.0);
        assertEquals(mathApplication.subtract(30.0, 20.0), 10.0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calculatorService).add(30.0, 20.0);
        inOrder.verify(calculatorService).subtract(30.0, 20.0);

        //Mockito provides option to create spy on real objects.
        // When spy is called, then actual method of real object is called.

    }

    /*
     *
     * BDD - Behavior Driven Development
     *
     * Behavior Driven Development is a style of writing tests uses given, when and then format as test methods.
     * Mockito provides special methods to do so.
     *
     * //Given
     * given(calculatorService.add(20.0,10.0)).willReturn(30.0);
     *
     * //when
     * double result = calculatorService.add(20.0,10.0);
     *
     * //then
     * Assert.assertEquals(result,30.0,0);
     *
     *
     * */

    @Test
    public void testAdd_using_BDD_Approach(){

        //Given
        given(calculatorService.add(20.0,10.0)).willReturn(30.0);

        //when
        double result = calculatorService.add(20.0,10.0);

        //then
        assertEquals(result,30.0,0);
    }

    /*
    *
    * Mockito provides a special Timeout option to test if a method is called within stipulated time frame.
    * Syntax
    * //passes when add() is called within 100 ms.
    * verify(calculatorService,timeout(100)).add(20.0,10.0);
    *
    * */

    @Test
    public void testAddAndSubtract(){

        //add the behavior to add numbers
        when(calculatorService.add(20.0,10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calculatorService.subtract(20.0,10.0)).thenReturn(10.0);

        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);

        //test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

        //verify call to add method to be completed within 100 ms
        verify(calculatorService, timeout(100)).add(20.0,10.0);

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given timeframe
        verify(calculatorService, timeout(100).times(1)).subtract(20.0,10.0);
    }

}
