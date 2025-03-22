package com.nikita.todolist.core.services;

import com.nikita.todolist.dto.response.ToDoListDeleteResponse;

public interface ToDoListDeleteService {
    ToDoListDeleteResponse deleteTask(Long id);
}
