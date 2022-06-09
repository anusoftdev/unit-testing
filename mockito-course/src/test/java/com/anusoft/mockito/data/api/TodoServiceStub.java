package com.anusoft.mockito.data.api;

import com.anusoft.mockito.data.api.data.api.TodoService;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* This is the stub class we have created in order to test the SUT
* with external dependency as TodoService.
*
* Stubs are the real implementation of the dependencies which
* is hard to create as well as maintain.
*
* We have not yet used mockito for testing
*
* */
public class TodoServiceStub implements TodoService {

    private Map<String, List<String>> userTodoMap = new HashMap<>();

    public TodoServiceStub() {
        setup();
    }

    public void setup() {
        userTodoMap.put("anurag", Arrays.asList("lean spring", "learn dance", "spring bean", "spring mvc"));
        userTodoMap.put("shivam", Arrays.asList("lean spring boot", "learn code", "spring security", "angular code"));
        userTodoMap.put("akarsh",Arrays.asList("lean spring boot", "learn code", "angular code"));
    }

    @Override
    public List<String> retrieveTodos(String username) {
        return userTodoMap.get(username);
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
