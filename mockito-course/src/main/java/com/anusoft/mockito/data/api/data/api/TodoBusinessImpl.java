package com.anusoft.mockito.data.api.data.api;

import java.util.List;
import java.util.stream.Collectors;

/*
*
* TodoBusinessImpl : it SUT (System Under Test)
* TodoService : It is dependency of TodoBusinessImpl
*
* */
public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String username) {
        return todoService.retrieveTodos(username).stream()
                .filter(todo -> todo.contains("spring") || todo.contains("Spring"))
                .collect(Collectors.toList());
    }

    public void deleteTodosNotRelatedToSpring(String username) {
        List<String> todosWithoutSpring = todoService.retrieveTodos(username).stream()
                .filter(todo -> !todo.contains("spring") || !todo.contains("Spring"))
                .collect(Collectors.toList());
        for(String todo : todosWithoutSpring) {
            todoService.deleteTodo(todo);
        }
    }
}
