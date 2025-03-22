package com.nikita.todolist.core.validation;

import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)


class DescriptionValidator implements Validation{

    private final ErrorValidationFactory errorValidationFactory;


    public Optional<ValidationError> validate(ToDoListRequest request) {
        return (request.getDescription() == null || request.getDescription().isEmpty())
                ? Optional.of(errorValidationFactory.processing("ERROR_CODE_1"))
                : Optional.empty();
    }
}
