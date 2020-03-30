package com.example.task.repository;

import com.example.task.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
    public Optional<User> findByUsername(String s);
    public void deleteAllByIdAndEmail(int id, String email);
}
