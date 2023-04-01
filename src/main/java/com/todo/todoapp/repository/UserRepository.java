package com.todo.todoapp.repository;

import com.todo.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    public List<User> findUsers();

    public User findUserById(Long id);

    public void deleteUserById(Long id);
}
