package com.orange.testingservicemockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository; // On mock le repository

    @InjectMocks
    private UserService userService; // Injection automatique du mock

    @Test
    void shouldReturnUserById() {
        User alice = new User(1L, "Alice");
        when(userRepository.findById(1L)).thenReturn(Optional.of(alice));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository, times(1)).findById(1L); // vérifie l'appel
    }

    @Test
    void shouldReturnAllUsers() {
        List<User> users = Arrays.asList(new User(1L,"Alice"), new User(2L,"Bob"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldCreateUser() {
        User charlie = new User(3L, "Charlie");
        when(userRepository.save(charlie)).thenReturn(charlie);

        User result = userService.createUser(charlie);

        assertNotNull(result);
        assertEquals("Charlie", result.getName());
        verify(userRepository, times(1)).save(charlie);
    }
}