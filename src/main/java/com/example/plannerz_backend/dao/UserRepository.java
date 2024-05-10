package com.example.plannerz_backend.dao;

import com.example.plannerz_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUseridAndUserpw(String userid, String userpw);

    User findUserByUserid(String userid);
}
