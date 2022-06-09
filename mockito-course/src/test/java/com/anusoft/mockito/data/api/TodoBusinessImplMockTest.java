package com.anusoft.mockito.data.api;

import com.anusoft.mockito.data.api.data.api.TodoBusinessImpl;
import com.anusoft.mockito.data.api.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

/*
*
* What is mock or mocking?
*
* Mocking is creating objects that simulate the behaviour of real objects.
* Unlike stubs, mocks can be dynamically created from code at runtime.
* Mocks offer more functionality than stubbing.
* You can verify method calls and a lot of other things.
*
* */
public class TodoBusinessImplMockTest {

    @Test
    public void test_using_mock() {
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        when(todoServiceMock.retrieveTodos("anurag"))
                .thenReturn(Arrays.asList("lean spring", "learn dance", "spring bean", "spring mvc"));
        List<String> springTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("anurag");

        assertEquals(3, springTodos.size());
    }

    @Test
    public void test_using_mock_new_way() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        given(todoServiceMock.retrieveTodos("anurag"))
                .willReturn(Arrays.asList("lean spring", "learn dance", "spring bean", "spring mvc"));

        //When
        List<String> springTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("anurag");

        //Then
        assertEquals(3, springTodos.size());
    }

    @Test
    public void test_delete_todos_without_spring() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        given(todoServiceMock.retrieveTodos("anurag"))
                .willReturn(Arrays.asList("lean spring", "learn dance", "learn dance", "spring bean", "spring mvc", "learn java"));

        //When
        //List<String> springTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("anurag");
        todoBusinessImpl.deleteTodosNotRelatedToSpring("anurag");


        //Then
        //verify(todoServiceMock, times(2)).deleteTodo("learn dance");
        //verify(todoServiceMock).deleteTodo("learn java");

        //verify(todoServiceMock, times(6)).deleteTodo(anyString());
        verify(todoServiceMock, never()).deleteTodo("learn spring");


    }
}
