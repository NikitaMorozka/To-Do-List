package com.nikita.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListUpdateResponse {
    private String title;
    private String description;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") private LocalDateTime dueDate;


}

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") private LocalDateTime updatedAt;
//    private Long userId;

//        existingTask.setTitle(updatedTaskData.getTitle());
//        existingTask.setDescription(updatedTaskData.getDescription());
//        existingTask.setStatus(updatedTaskData.getStatus());
//        existingTask.setDueDate(updatedTaskData.getDueDate());