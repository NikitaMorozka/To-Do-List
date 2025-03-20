package com.nikita.todolist.core.services;

import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ToDoListResponse;

public interface ToDoListService {
    ToDoListResponse createTask(ToDoListRequest request);
}
