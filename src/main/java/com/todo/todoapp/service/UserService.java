package com.todo.todoapp.service;

import com.todo.todoapp.dto.UserRequest;
import com.todo.todoapp.model.User;
import com.todo.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserService() {
    }

    public User createNewUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findUsers();
    }

    public User getUserById(Long id) {
        return repository.findUserById(id);
    }

    public void delete(Long id) {
        repository.deleteUserById(id);
    }

}
