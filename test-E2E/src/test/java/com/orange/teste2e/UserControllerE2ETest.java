package com.orange.teste2e;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserControllerE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createUserThenLogin() {
        // 1️⃣ Créer un utilisateur
        User newUser = new User(1L, "alice", "password123");

        given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/api/users")
                .then()
                .statusCode(200)
                .body("username", equalTo("alice"));

        // 2️⃣ Se connecter avec les mêmes credentials
        User loginUser = new User();
        loginUser.setUsername("alice");
        loginUser.setPassword("password123");

        given()
                .contentType("application/json")
                .body(loginUser)
                .when()
                .post("/api/users/login")
                .then()
                .statusCode(200)
                .body("username", equalTo("alice"));

        // 3️⃣ Vérification finale via GET /api/users
        when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].username", equalTo("alice"));
    }
}