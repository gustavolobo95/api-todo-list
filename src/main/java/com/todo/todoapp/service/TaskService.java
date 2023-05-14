package com.todo.todoapp.service;

import com.todo.todoapp.model.Task;
import com.todo.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> listarTasks() {
        return (List<Task>) repository.findAll();
    }

}

