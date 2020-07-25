package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;


public interface UserService{
    User createUser(UserDTO users) throws GlobalExceptionHandler;
    Boolean updatePassword(ForgetPWDDTO forgetPWDDTO) throws GlobalExceptionHandler;
}