package com.example.task;
import com.example.task.model.Task;
import com.example.task.model.User;
import com.example.task.repository.TaskRepo;
import com.example.task.repository.UserRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class PreloadData {

      @Bean
       CommandLineRunner initDatabase2(UserRepo userRepo) {

           userRepo.deleteAll();


           return (args) -> Stream.of(users())
                   .peek(System.out::println)

                   .forEach(userRepo::save);
       }

       private User[] users() {
           return new User[]{
                   new User(1, "Bakulya","admin", new BCryptPasswordEncoder().encode("test123")),
                   new User(2, "Anara","user1", new BCryptPasswordEncoder().encode("123user")),
                   new User(3,"Meder", "guest", new BCryptPasswordEncoder().encode("guest2"))};
       }
 /*   @Bean
    CommandLineRunner initDatabase3(TaskRepo taskRepo) {

        taskRepo.deleteAll();

        return (args) -> Stream.of(tasks())
                .peek(System.out::println)

                .forEach(taskRepo::save);
    }

    private Task[] tasks() {
          User [] users = new User[0];
        return new Task[]{
                new Task(1, "pass exam", "7 month",  LocalDate.of(2020,3,27),users[1]),
                new Task(2, "do homework", "add",LocalDate.of(2020,3,30),users[1])};
    }
   */

 /*   @Bean
    CommandLineRunner initDatabase(UserRepo userRepo, TaskRepo taskRepo){
        return (args) -> {
            userRepo.deleteAll();
            taskRepo.deleteAll();



            List<User> userList = new ArrayList<>();
            userList.add(new User(1, "Bakulya","admin", new BCryptPasswordEncoder().encode("test123")));
            userList.add(new User(2, "Anara","user1", new BCryptPasswordEncoder().encode("qwerty")));
            userRepo.saveAll(userList);

            List<Task> placeList = new ArrayList<>();
            placeList.add(new Task(1, "pass exam","7 month", LocalDate.of(2020,3,27), userList.get(1)));
            placeList.add(new Task(2, "do homework","add", LocalDate.of(2020,3,27), userList.get(1)));
            taskRepo.saveAll(placeList);




        };
    }*/
}