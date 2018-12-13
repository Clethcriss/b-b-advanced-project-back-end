package com.codecool.bbbt.huntapped.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String nickName;
    @Transient
    private int totalCheckIns;
    private String password;
    private String passwordConfirm;

    public Users(LoginForm loginForm){
        this.username = loginForm.getUsername();
        this.password = loginForm.getPassword();
    }

}
