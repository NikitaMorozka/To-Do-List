package com.nikita.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nikita.todolist.core.domain.User;
import com.nikita.todolist.dto.CoreResponse;
import com.nikita.todolist.dto.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListCreateResponse extends CoreResponse {
    private String title;
    private String description;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") private LocalDateTime dueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") private LocalDateTime createdAt;//когда задача была создана
    private User user;

    //    private LocalDateTime updatedAt;//когда задача была обновлена
    public ToDoListCreateResponse(List<ValidationError> errors) {
        super(errors);
    }
}
