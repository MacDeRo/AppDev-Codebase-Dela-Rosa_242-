package com.example.appdev_debugging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.appdev_debugging.auth.AuthManager;
import com.example.appdev_debugging.auth.AuthResult;
import com.example.appdev_debugging.data.InMemoryUserRepository;
import com.example.appdev_debugging.data.UserRepository;

import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void login_shouldBeCaseInsensitiveForEmail() {
        UserRepository repository = new InMemoryUserRepository();
        AuthManager authManager = new AuthManager(repository);

        authManager.register(
                "Juan Dela Cruz",
                "Juan.DelaCruz@Mail.ph",
                "password1234567",
                "password1234567"
        );

        AuthResult result = authManager.login(
                "juan.delacruz@mail.ph",
                "password1234567"
        );

        assertTrue(result.isSuccess());
    }
}