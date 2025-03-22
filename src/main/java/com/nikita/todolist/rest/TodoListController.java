package com.nikita.todolist.rest;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.services.ToDoListCreateService;
import com.nikita.todolist.core.services.ToDoListDeleteService;
import com.nikita.todolist.core.services.ToDoListGetService;
import com.nikita.todolist.core.services.ToDoListUpdateService;
import com.nikita.todolist.dto.request.ToDoLiatTaskIdRequest;
import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.response.ToDoListCreateResponse;
import com.nikita.todolist.dto.response.ToDoListDeleteResponse;
import com.nikita.todolist.dto.response.ToDoListGetResponse;
import com.nikita.todolist.dto.response.ToDoListUpdateResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/tasks")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TodoListController {

    private final ToDoListCreateService toDoListCreateService;
    private final ToDoListUpdateService toDoListUpdateService;
    private final ToDoListDeleteService toDoListDeleteService;
    private final ToDoListGetService toDoListGetService;

    @PostMapping(consumes = "application/json",
            produces = "application/json")
    public ToDoListCreateResponse createTask(@RequestBody ToDoListRequest request) {
        return toDoListCreateService.createTask(request);
    }

    @GetMapping("/user/{userId}")
    public List<ToDoListGetResponse> getTasksByUserId(@PathVariable Long userId) {
        return toDoListGetService.getTasks(userId);
    }

    @PutMapping("/user")
    public ToDoListUpdateResponse updateTask(@RequestBody ToDoLiatTaskIdRequest request) {
        return toDoListUpdateService.updateTask(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoListDeleteResponse> deleteTask(@PathVariable Long id) {
        ToDoListDeleteResponse response = toDoListDeleteService.deleteTask(id);
        return ResponseEntity.ok(response);
    }
}


//{
//  "userId": 1,
//  "title": "dsf",
//  "description": "укп",
//  "status": "укпуп",
//  "dueDate": "2026-11-25 11:54:11"
//}

//localhost:8080/todo/tasks/user/1

//localhost:8080/todo/tasks/1008


//{
//  "title": "Обновлённое название задачи",
//  "description": "Обновлённое описание задачи",
//  "status": "В процессе",
//  "dueDate": "2025-04-01T10:00:00"
//}