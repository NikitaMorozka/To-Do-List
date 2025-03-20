package com.nikita.todolist.rest;

import com.nikita.todolist.core.services.ToDoListService;
import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ToDoListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo/tasks")
public class TodoListController {

    private final ToDoListService toDoListService;

    TodoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ToDoListResponse calculatePremium(@RequestBody ToDoListRequest request) {
        return toDoListService.createTask(request);
    }
}
