package com.orange.testingstrategymvc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnUserById() {
        ResponseEntity<User> response = restTemplate.getForEntity("/api/users/1", User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Alice", response.getBody().getName());
    }

    @Test
    void shouldReturnAllUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("/api/users", User[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length >= 2);
    }

    @Test
    void shouldCreateUser() {
        User newUser = new User(3, "Charlie");
        ResponseEntity<User> response = restTemplate.postForEntity("/api/users", newUser, User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Charlie", response.getBody().getName());
    }

}
