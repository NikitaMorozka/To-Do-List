package com.nikita.todolist.core.validation;

import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;

import java.util.List;

public interface ToDoRequestValidator {
    List<ValidationError> validate(ToDoListRequest request);
}
