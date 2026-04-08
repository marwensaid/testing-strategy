package com.orange.teste2e;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) { this.repository = repository; }

    public User createUser(User user) { return repository.save(user); }

    public User login(String username, String password) {
        return repository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    public List<User> getAllUsers() { return repository.findAll(); }
}