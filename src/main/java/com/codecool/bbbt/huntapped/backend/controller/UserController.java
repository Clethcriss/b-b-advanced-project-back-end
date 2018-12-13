package com.codecool.bbbt.huntapped.backend.controller;

import com.auth0.jwt.JWT;
import com.codecool.bbbt.huntapped.backend.model.LoginForm;
import com.codecool.bbbt.huntapped.backend.model.Users;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.codecool.bbbt.huntapped.backend.security.SecurityConstants.EXPIRATION_TIME;
import static com.codecool.bbbt.huntapped.backend.security.SecurityConstants.SECRET;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Long id) {
        Users user = userRepository.findUserById(id);
        log.info("Got user by id: {}. User is {}", id, user);
        return user;
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody LoginForm loginForm){
        log.info("Registering user with username: {} password: {}", loginForm.getUsername(),loginForm.getPassword());
        loginForm.setPassword(bCryptPasswordEncoder.encode(loginForm.getPassword()));
        Users newUsers = new Users(loginForm);
        userRepository.save(newUsers);
        return true;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm){
        Users user = userRepository.findUserByUsername(loginForm.getUsername());
        if (user != null){
            log.info("User logged in with user:{}", user);
            if(bCryptPasswordEncoder.matches(loginForm.getPassword(), user.getPassword())){
                return JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(HMAC512(SECRET.getBytes()));
            }
        }
        log.warn("Log in with username: {} failed!",loginForm.getUsername());
        return null;
    }
}
