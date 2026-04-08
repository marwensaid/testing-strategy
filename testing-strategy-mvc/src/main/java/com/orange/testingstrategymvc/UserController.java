package com.orange.testingstrategymvc;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final Map<Integer, User> users = new HashMap<>();

    public UserController() {
        users.put(1, new User(1, "Alice"));
        users.put(2, new User(2, "Bob"));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        if (!users.containsKey(id)) {
            throw new NoSuchElementException("Utilisateur non trouvé");
        }
        return users.get(id);
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }

}
