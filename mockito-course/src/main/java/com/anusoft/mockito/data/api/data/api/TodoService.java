package com.anusoft.mockito.data.api.data.api;

import java.util.List;

public interface TodoService {
    public List<String> retrieveTodos(String username);
    public void deleteTodo(String todo);
}
