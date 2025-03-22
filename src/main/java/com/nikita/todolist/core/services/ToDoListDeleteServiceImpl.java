package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.repositories.TaskRepository;
import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.response.ToDoListDeleteResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ToDoListDeleteServiceImpl implements ToDoListDeleteService{

    private final TaskRepository taskRepository;

    public ToDoListDeleteResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.delete(task);  // Удаляем задачу из базы данных

       return new ToDoListDeleteResponse("Task with id " + id + " deleted successfully");
    }
}
