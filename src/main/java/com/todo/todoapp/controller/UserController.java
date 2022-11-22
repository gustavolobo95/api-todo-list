package com.todo.todoapp.controller;

import com.todo.todoapp.dto.UserRequest;
import com.todo.todoapp.model.Task;
import com.todo.todoapp.model.User;
import com.todo.todoapp.repository.TaskRepository;
import com.todo.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/save/user")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest request) {
        if(request.getUser() != null) {
            userRepository.save(request.getUser());
        }
        return request.getUser() != null ? new ResponseEntity<>(request.getUser(), HttpStatus.CREATED) :
                new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        if (!userRepository.getAllUsers().isEmpty()) {
            return new ResponseEntity<>(userRepository.getAllUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/user/get")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        return userRepository.findById(id).isPresent() ?
                new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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
    public ResponseEntity<List<Task>> getTasks() {
        if(!taskRepository.getAllTasks().isEmpty()) {
            return new ResponseEntity<>(taskRepository.getAllTasks(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

}
