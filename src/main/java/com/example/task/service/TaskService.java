package com.example.task.service;


import com.example.task.dto.Answer;
import com.example.task.model.Task;
import com.example.task.model.User;
import com.example.task.repository.TaskRepo;
import com.example.task.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TaskRepo taskRepo;



    public void removeTaskByIdandUser(int id, User user) {
        taskRepo.deleteAllByIdAndUser(id, this.getUser());
    }
    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByUsername(auth.getName()).get();
    }
    public List<Task> getTaskByTitle(String title) {
        return taskRepo.findAllByTitle(title).stream().filter(s -> s.getUser().getUsername().equals(this.getUser().getUsername())).collect(Collectors.toList());
    }



   /* public List<Task> getTaskList() {
        List<Task> result = new ArrayList<>();
        taskRepo.findAll().forEach(result::add);
        return result;
    }*/

    public Task setTask(int id, String title, String description, LocalDate dateTime, User user) {
        return taskRepo.save(new Task(id,  title, description,dateTime, this.getUser()));
    }


  /*  public Answer checkTask (int taskId, String title) {
        Optional<Task> task = taskRepo.findById(taskId);
        if (task == null || task.isEmpty())
            return new Answer("Task not found!");
        else if (task.get().getDateTime().isBefore(LocalDate.now()))
            return new Answer("Task expired!");

        if (!taskRepo.findByUserAndTitle(title, this.getUser()).isEmpty())
            return new Answer("Task already filled!");

        return new Answer(Integer.toString(taskId), "Task added successfully!");
    }*/




}
