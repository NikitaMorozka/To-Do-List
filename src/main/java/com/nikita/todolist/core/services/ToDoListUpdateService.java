package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.dto.request.ToDoLiatTaskIdRequest;
import com.nikita.todolist.dto.response.ToDoListUpdateResponse;

public interface ToDoListUpdateService {
    ToDoListUpdateResponse updateTask(ToDoLiatTaskIdRequest request) ;
}
