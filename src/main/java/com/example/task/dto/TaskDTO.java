package com.example.task.dto;


import com.example.task.dto.UserDTO;
import com.example.task.model.State;


import java.time.LocalDateTime;

public class TaskDTO {
    private int id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private UserDTO user;
    private State state;


}
