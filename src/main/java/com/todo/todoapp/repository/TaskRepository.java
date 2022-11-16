package com.todo.todoapp.repository;

import com.todo.todoapp.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("SELECT t from Task t")
    List<Task> getAllTasks();

}
