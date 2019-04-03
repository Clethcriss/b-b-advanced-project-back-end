package com.codecool.bbbt.huntapped.backend.repository;

import com.codecool.bbbt.huntapped.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.totalCheckIns = u.totalCheckIns+1 where u.username =:username")
    void incrementNumberOfRatingsByUsername(@Param("username") String username);
}
