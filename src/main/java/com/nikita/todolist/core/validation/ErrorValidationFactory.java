package com.nikita.todolist.core.validation;

import com.nikita.todolist.core.util.ErrorMessageUtil;
import com.nikita.todolist.core.util.Placeholder;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Component
public class ErrorValidationFactory {

    private final ErrorMessageUtil errorCodeUtil;

    ValidationError processing(String error) {
        String err = errorCodeUtil.getErrorDescription(error);
        return new ValidationError(error, err);
    }
} 
