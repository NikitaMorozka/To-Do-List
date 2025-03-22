package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.core.repositories.TaskRepository;
import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.response.ToDoListCreateResponse;
import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.ValidationError;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ToDoListCreateServiceImpl implements ToDoListCreateService {

    private final ToDoRequestValidator toDoRequestValidator;
    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public ToDoListCreateResponse createTask(ToDoListRequest request) {
        List<ValidationError> errors = toDoRequestValidator.validate(request);
        return errors.isEmpty()
                ? taskMapper.toCreateResponse(saveTask(request))
                : new ToDoListCreateResponse(errors);
    }

    private Task saveTask(ToDoListRequest request) {
        LocalDateTime createdAt = LocalDateTime.now();
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());
        task.setCreated_at(createdAt);

        User user = new User();
        user.setId(request.getUserId());
        task.setUser(user);
        return taskRepository.save(task);
    }
}
