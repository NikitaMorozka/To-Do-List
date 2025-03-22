package com.nikita.todolist.core.services;

import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.response.ToDoListCreateResponse;

public interface ToDoListCreateService {
    ToDoListCreateResponse createTask(ToDoListRequest request);
}
