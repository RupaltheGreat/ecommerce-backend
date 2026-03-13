package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.dto.LoginRequest;
import com.ecommerce.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if(request.getEmail().equals("admin@gmail.com")
           && request.getPassword().equals("1234")) {

            return jwtUtil.generateToken(request.getEmail());
        }

        return "Invalid credentials";
    }
}