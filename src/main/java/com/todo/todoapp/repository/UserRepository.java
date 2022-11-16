package com.todo.todoapp.repository;

import com.todo.todoapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u from User u")
    List<User> getAllUsers();

}
