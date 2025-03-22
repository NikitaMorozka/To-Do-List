package com.nikita.todolist.core;
import com.nikita.todolist.core.services.ToDoListCreateServiceImpl;
import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.request.ToDoListRequest;
import com.nikita.todolist.dto.response.ToDoListCreateResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoListCreateServiceImplTest {
    @Mock
    ToDoListRequest request;
    @Mock
    ToDoRequestValidator toDoRequestValidator;

    @InjectMocks
    ToDoListCreateServiceImpl toDoListCreateServiceImpl;

    @Test
    void shouldPopulateResponse() {
        when(request.getTitle()).thenReturn("Учеба");
        when(request.getDescription()).thenReturn("Дз по математике");
        when(request.getStatus()).thenReturn("ВЫПОЛНЯЕТСЯ");
        when(request.getDueDate()).thenReturn(LocalDateTime.now().plusDays(7L));
        when(toDoRequestValidator.validate(request)).thenReturn(List.of());

        ToDoListCreateResponse response = toDoListCreateServiceImpl.createTask(request);

        assertEquals(response.getTitle(), request.getTitle());
        assertEquals(response.getDescription(), request.getDescription());
        assertEquals(response.getStatus(), request.getStatus());
        assertEquals(response.getDueDate(), request.getDueDate());
        assertTrue(response.getCreatedAt() != null);
    }
}
