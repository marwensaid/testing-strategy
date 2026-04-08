package com.orange.teste2e;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @PostMapping
    public User createUser(@RequestBody User user) { return service.createUser(user); }

    @PostMapping("/login")
    public User login(@RequestBody User credentials) {
        return service.login(credentials.getUsername(), credentials.getPassword());
    }

    @GetMapping
    public List<User> getAllUsers() { return service.getAllUsers(); }
}