package com.libraryexample.library.controller;

import com.libraryexample.library.model.Users;
import com.libraryexample.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userService.register(users);
    }

    @GetMapping("/login")
    public String login(@RequestBody Users users){
        return userService.verify(users);
    }
}
