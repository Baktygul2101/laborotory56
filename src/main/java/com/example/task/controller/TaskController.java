package com.example.task.controller;


import com.example.task.dto.Answer;
import com.example.task.model.Task;
import com.example.task.model.User;
import com.example.task.service.TaskService;
import com.example.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @PostMapping("/")
    public Task saveNewTask(@RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("dateTime") String dateTime,  @RequestParam("user") User user) {
        return taskService.setTask(id, title, description, LocalDate.parse(dateTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")), user);
    }

    @GetMapping("/")
    public List<Task> getTaskByTitle(@RequestParam("title") String title) {
        return taskService.getTaskByTitle(title);
    }

    @DeleteMapping("/")
    public void removeTask(@RequestParam("id") int id,@RequestParam("user") User user ) {
        taskService.removeTaskByIdandUser(id, user);
    }

   /* @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskService.getTaskList();
    }*/


}
