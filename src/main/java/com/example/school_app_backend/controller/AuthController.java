package com.example.school_app_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {

        String username = user.get("username");
        String role = user.get("role"); // e.g., ROLE_CHILD, ROLE_CLASS_TEACHER, ROLE_PRINCIPAL

        String token = "dummy-token-for-" + username;

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", role);
        response.put("username", username);
        return response;
    }
}
