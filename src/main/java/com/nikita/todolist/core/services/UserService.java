package com.nikita.todolist.core.services;


import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.core.repositories.TaskRepository;
import com.nikita.todolist.core.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // нужно захэшировать
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) { // лучше сделать отдельный класс валидатор
            return user;
        }
        return null;
    }


}
