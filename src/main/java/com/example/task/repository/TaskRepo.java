package com.example.task.repository;

import com.example.task.model.State;
import com.example.task.model.Task;
import com.example.task.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends CrudRepository<Task, Integer> {
    public List<Task> findAllByTitle(String title);

    public void deleteAllByIdAndUser(int id, User user);

    public List<Task> findByUserAndTitle(String title, User user);
    public List<Task> findAll();


    public void deleteAllByIdAndTitle(int id, String title);

    public void deleteAllByIdAndTitleAndUser(int id, String title, User user);

    public List<Task> findByUserAndTitle(User user, String title);



}