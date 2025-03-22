package com.nikita.todolist.core.services;

import com.nikita.todolist.dto.response.ToDoListGetResponse;

import java.util.List;

public interface ToDoListGetService {
    List<ToDoListGetResponse> getTasks(Long userId);
}
