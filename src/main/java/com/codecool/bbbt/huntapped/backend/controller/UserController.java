package com.codecool.bbbt.huntapped.backend.controller;

import com.codecool.bbbt.huntapped.backend.model.User;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findUserById(id);
    }
}
