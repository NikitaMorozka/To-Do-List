package com.nikita.todolist.core;
import com.nikita.todolist.core.services.ToDoListServiceImpl;
import com.nikita.todolist.core.validation.ToDoRequestValidator;
import com.nikita.todolist.dto.ToDoListRequest;
import com.nikita.todolist.dto.ToDoListResponse;
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
class ToDoListServiceImplTest {
    @Mock
    ToDoListRequest request;
    @Mock
    ToDoRequestValidator toDoRequestValidator;

    @InjectMocks ToDoListServiceImpl toDoListServiceImpl;

    @Test
    void shouldPopulateResponse() {
        when(request.getTitle()).thenReturn("Учеба");
        when(request.getDescription()).thenReturn("Дз по математике");
        when(request.getStatus()).thenReturn("ВЫПОЛНЯЕТСЯ");
        when(request.getDueDate()).thenReturn(LocalDateTime.now().plusDays(7L));
        when(toDoRequestValidator.validate(request)).thenReturn(List.of());

        ToDoListResponse response = toDoListServiceImpl.createTask(request);

        assertEquals(response.getTitle(), request.getTitle());
        assertEquals(response.getDescription(), request.getDescription());
        assertEquals(response.getStatus(), request.getStatus());
        assertEquals(response.getDueDate(), request.getDueDate());
        assertTrue(response.getCreatedAt() != null);
    }
}
