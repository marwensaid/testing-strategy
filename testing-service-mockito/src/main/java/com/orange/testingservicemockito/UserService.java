package com.orange.testingservicemockito;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }
}