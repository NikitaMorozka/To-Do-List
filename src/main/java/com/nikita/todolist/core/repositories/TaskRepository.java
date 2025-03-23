package com.nikita.todolist.core.repositories;

import com.nikita.todolist.core.domain.Task;
import com.nikita.todolist.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
