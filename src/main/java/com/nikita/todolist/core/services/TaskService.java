package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.core.repositories.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(User user) {
        return taskRepository.findByUser(user);
    }

    public void createTask(String title, String description, User user) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(false);
        task.setUser(user);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("INVALID task id"));
        task.setStatus(task.getStatus() != true);
        taskRepository.save(task);
    }
}