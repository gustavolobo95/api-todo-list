package com.todo.todoapp.controller;

import com.todo.todoapp.dto.UserRequest;
import com.todo.todoapp.model.Task;
import com.todo.todoapp.model.User;
import com.todo.todoapp.repository.TaskRepository;
import com.todo.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/save/user")
    public User saveUser(@RequestBody UserRequest request) {
        userRepository.save(request.getUser());
        return request.getUser();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        if (!userRepository.getAllUsers().isEmpty()) {
            return userRepository.getAllUsers();
        } else {
            return null;
        }
    }

    @GetMapping("/user/get")
    public User getUserById(@RequestParam Long id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    @DeleteMapping("/user/delete")
    public HttpStatus deleteUserById(@RequestParam Long id) {
            boolean isPresent = userRepository.existsById(id);
            if(isPresent) {
                userRepository.deleteById(id);
            } else {
                return HttpStatus.NOT_FOUND;
            }
            return HttpStatus.OK;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        if(!taskRepository.getAllTasks().isEmpty()) {
            return taskRepository.getAllTasks();
        } else {
            return null;
        }
    }

}
