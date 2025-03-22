package com.nikita.todolist.core.validation;

import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)

class DueDateValidation implements Validation{

    private final ErrorValidationFactory errorValidationFactory;


    public Optional<ValidationError> validate(ToDoListRequest request) {
        return (request.getDueDate() == null || checkDate(request.getDueDate()))
                ? Optional.of(errorValidationFactory.processing("ERROR_CODE_2"))
                : Optional.empty();
    }

    private Boolean checkDate(LocalDateTime localDateTime){
        return localDateTime.isBefore(LocalDateTime.now());
    }
}
