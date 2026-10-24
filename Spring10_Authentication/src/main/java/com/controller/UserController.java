package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.jwt.entity.UserInfo;
import com.jwt.service.jwtService;
import com.jwt.service.UserInfoDetails;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoDetails userService;

    @Autowired
    private jwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo user) {
        return userService.addUser(user);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody UserInfo user) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getName(), user.getPassword()
            )
        );

        return jwtService.generateToken(user.getName());
    }

    @GetMapping("/user/userProfile")
    public String userProfile() {
        return "Welcome! You accessed the protected user profile.";
    }
}