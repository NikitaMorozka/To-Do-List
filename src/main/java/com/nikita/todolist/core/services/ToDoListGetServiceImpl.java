package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.repositories.TaskRepository;
import com.nikita.todolist.dto.response.ToDoListGetResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ToDoListGetServiceImpl implements ToDoListGetService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<ToDoListGetResponse> getTasks(Long userId) {
        List<Task> tasks = taskRepository.findByUserId(userId); // Получаем все задачи по userId
        return tasks.stream().map(task -> taskMapper.toCreateGetResponse(task))
                .collect(Collectors.toList());
    }
}
