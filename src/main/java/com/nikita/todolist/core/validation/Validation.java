package com.nikita.todolist.core.validation;

import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;

import java.util.Optional;

interface Validation {
    Optional<ValidationError> validate (ToDoListRequest request);
}
