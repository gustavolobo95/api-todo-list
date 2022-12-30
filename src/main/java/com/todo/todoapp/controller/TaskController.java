package com.todo.todoapp.controller;

import com.todo.todoapp.model.Task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks/{id}")
    public ResponseEntity<List<Task>> getTasksById(@PathVariable Long id) {
        if(!taskRepository.getTaskById(id).isEmpty()) {
            return new ResponseEntity<>(taskRepository.getTaskById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

}
