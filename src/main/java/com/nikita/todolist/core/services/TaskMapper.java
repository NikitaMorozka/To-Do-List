package com.nikita.todolist.core.services;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.dto.response.ToDoListCreateResponse;
import com.nikita.todolist.dto.response.ToDoListGetResponse;
import com.nikita.todolist.dto.response.ToDoListUpdateResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TaskMapper {

    public ToDoListCreateResponse toCreateResponse(Task task) {
        return new ToDoListCreateResponse(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreated_at(),
                task.getUser()
        );
    }

    public ToDoListGetResponse toCreateGetResponse(Task task) {
        return new ToDoListGetResponse(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreated_at()
        );
    }

    public ToDoListUpdateResponse mapToUpdateResponse(Task task){
        return new ToDoListUpdateResponse(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate()
        );
    }
}

