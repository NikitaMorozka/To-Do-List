package com.nikita.todolist.rest;

import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.core.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.createUser(email, password);
        session.setAttribute("user", user);
        return "redirect:/tasks";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.loginUser(email, password);
        if (user == null) return "redirect:/login";
        session.setAttribute("user", user);
        return "redirect:/tasks";
    }
}