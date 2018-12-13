package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {
    private String username;
    private String password;
    private String email;
    private String name;

}
