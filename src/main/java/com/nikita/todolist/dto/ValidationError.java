package com.nikita.todolist.dto;

public record ValidationError(String errorCode, String description){
    public ValidationError(){
        this("...", "...");
    }
}
