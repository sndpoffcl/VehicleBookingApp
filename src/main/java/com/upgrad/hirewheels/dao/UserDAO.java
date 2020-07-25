package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("userDAO")
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
    User findByEmailAndMobileNo(String email, String mobileNo);
    User findByEmail(String email);
    User findByMobileNo(String mobileNo);
}
