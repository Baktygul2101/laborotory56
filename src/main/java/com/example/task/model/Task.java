package com.example.task.model;

import com.example.task.model.User;
import com.example.task.model.State;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
public class Task {
    @Id
    private int id;
    private String title;
    private String description;
    private LocalDate dateTime;
    @DBRef
    private User user;
    private State state;

    public Task(int id, String title, String description,LocalDate dateTime, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = LocalDate.now();
        this.user = user;
    }



}
