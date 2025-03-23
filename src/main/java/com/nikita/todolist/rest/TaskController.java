package com.nikita.todolist.rest;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.core.services.TaskService;

import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public String getTasks(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if(currentUser == null){
            return "redirect:/login";
        }
        List<Task> task = taskService.getAllTasks(currentUser);
        model.addAttribute("tasks", task);
        return "tasks";
    }

    @PostMapping()
    public String postTasks(@RequestParam String title, @RequestParam String description, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) return "redirect:/login";
        taskService.createTask(title, description, currentUser);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }
}