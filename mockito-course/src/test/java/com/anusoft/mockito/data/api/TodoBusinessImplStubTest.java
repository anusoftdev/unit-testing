package com.anusoft.mockito.data.api;

import com.anusoft.mockito.data.api.data.api.TodoBusinessImpl;
import com.anusoft.mockito.data.api.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void test() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> springTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("anurag");

        assertEquals(3, springTodos.size());
    }
}
