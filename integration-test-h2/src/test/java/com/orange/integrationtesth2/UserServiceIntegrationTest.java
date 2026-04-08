package com.orange.integrationtesth2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")@Transactional // rollback automatique après chaque test
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldCreateAndRetrieveUser() {
        User alice = new User(1L, "Alice");
        userService.createUser(alice);

        User retrieved = userService.getUserById(1L);
        assertNotNull(retrieved);
        assertEquals("Alice", retrieved.getName());
    }

    @Test
    void shouldUpdateUser() {
        User bob = new User(2L, "Bob");
        userService.createUser(bob);

        bob.setName("Bobby");
        userService.updateUser(bob);

        User updated = userService.getUserById(2L);
        assertEquals("Bobby", updated.getName());
    }

    @Test
    void shouldReturnAllUsers() {
        userService.createUser(new User(1L, "Alice"));
        userService.createUser(new User(2L, "Bob"));

        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void shouldDeleteUser() {
        userService.createUser(new User(3L, "Charlie"));
        userService.deleteUser(3L);

        User deleted = userService.getUserById(3L);
        assertNull(deleted);
    }
}