package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.repositories.TaskRepository;
import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.request.ToDoLiatTaskIdRequest;
import com.nikita.todolist.dto.response.ToDoListUpdateResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ToDoListUpdateServiceImpl implements ToDoListUpdateService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public ToDoListUpdateResponse updateTask(ToDoLiatTaskIdRequest request) {
        Task existingTask = taskRepository.findById(request.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + request.getTaskId()));
        updateTaskFields(existingTask, request);
        return taskMapper.mapToUpdateResponse(taskRepository.save(existingTask));
    }

    private void updateTaskFields(Task existingTask, ToDoLiatTaskIdRequest request) {
        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setStatus(request.getStatus());
        existingTask.setDueDate(request.getDueDate());
    }

}
