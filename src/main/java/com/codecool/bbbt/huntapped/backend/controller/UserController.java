package com.codecool.bbbt.huntapped.backend.controller;

import com.auth0.jwt.JWT;
import com.codecool.bbbt.huntapped.backend.model.LoginForm;
import com.codecool.bbbt.huntapped.backend.model.RegisterForm;
import com.codecool.bbbt.huntapped.backend.model.ResponseString;
import com.codecool.bbbt.huntapped.backend.model.User;
import com.codecool.bbbt.huntapped.backend.model.UserForm;
import com.codecool.bbbt.huntapped.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUserById(@PathVariable("id") Long id) {
        User user = userRepository.findUserById(id);
        log.info("Got user by id: {}. User is {}", id, user);
        return user;
    }

    @GetMapping("/name={name}")
    public UserForm getUserByName(@PathVariable("name") String name) {
        User user = userRepository.findUserByUsername(name);
        log.info("Got user by name: {}. User is {}", name, user);
        UserForm userForm = new UserForm(user.getId(), user.getUsername(), user.getName(), user.getTotalCheckIns());
        return userForm;
    }


    @PostMapping("/register")
    public boolean registerUser(@RequestBody RegisterForm registerForm){
        log.info("Registering user with user: {}", registerForm);
        registerForm.setPassword(bCryptPasswordEncoder.encode(registerForm.getPassword()));
        User newUser = new User(registerForm);
        if (userRepository.findUserByEmail(newUser.getEmail()) != null || userRepository.findUserByUsername(newUser.getUsername()) != null) {
            return false;
        }
        newUser.setTotalCheckIns(0);
        userRepository.save(newUser);
        return true;
    }

    @PostMapping("/login")
    public ResponseString login(@RequestBody LoginForm loginForm){
        User user = userRepository.findUserByUsername(loginForm.getUsername());
        if (user != null){
            log.info("User logged in with user:{}", user);
            if(bCryptPasswordEncoder.matches(loginForm.getPassword(), user.getPassword())){
                ResponseString responseString = new ResponseString(JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .sign(HMAC512(SECRET.getBytes())));
                return responseString;
            }
        }
        log.warn("Log in with username: {} failed!",loginForm.getUsername());
        return new ResponseString();
    }
}
