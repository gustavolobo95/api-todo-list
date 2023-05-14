package com.todo.todoapp.controller;

import com.todo.todoapp.dto.UserRequest;
import com.todo.todoapp.model.Task;
import com.todo.todoapp.model.User;
import com.todo.todoapp.repository.TaskRepository;
import com.todo.todoapp.repository.UserRepository;
import com.todo.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest request) {
        return new ResponseEntity<>(service.createNewUser(request.getUser()), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
            return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUserById(@PathVariable Long id) {
            service.delete(id);
            return HttpStatus.OK;
    }

}
