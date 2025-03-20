package com.nikita.todolist.core.validation;

import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)

class StatusValidation implements Validation { //  поправить
    public Optional<ValidationError> validate(ToDoListRequest request) {
        return (request.getStatus() == null || request.getStatus().isEmpty())
                ? Optional.of(new ValidationError("Status", "Must not be empty!"))
                : Optional.empty();
    }
}
