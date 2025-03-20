package com.nikita.todolist.core.validation;


import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)

class TitleValidator implements Validation{
    public Optional<ValidationError> validate(ToDoListRequest request) {
        return (request.getTitle() == null || request.getTitle().isEmpty())
                ? Optional.of(new ValidationError("Title", "Must not be empty!"))
                : Optional.empty();
    }
}
