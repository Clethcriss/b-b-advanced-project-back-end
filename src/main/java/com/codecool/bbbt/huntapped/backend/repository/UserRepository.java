package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
