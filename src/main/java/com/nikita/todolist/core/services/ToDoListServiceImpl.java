package com.nikita.todolist.core.services;

import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.ToDoListResponse;
import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoRequestValidator toDoRequestValidator;

    @Override
    public ToDoListResponse createTask(ToDoListRequest request) {
        List<ValidationError> errors = toDoRequestValidator.validate(request);
        return errors.isEmpty()
                ? getToDoListResponse(request)
                : new ToDoListResponse(errors);
    }

    private ToDoListResponse getToDoListResponse(ToDoListRequest request) {
        return new ToDoListResponse(
                request.getTitle(),
                request.getDescription(),
                request.getStatus(),
                request.getDueDate(), // статус задачи, если задача просрачивается, то инидикатор в респонсе должно вернуть просрочка
                createDateTimeTask() // время создания задачи
        );
    }

    private LocalDateTime createDateTimeTask() {
        return LocalDateTime.now();
    }
}
