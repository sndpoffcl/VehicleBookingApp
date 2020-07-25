package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;

public interface UserValidator {
   void validateuserLogin(LoginDTO user) throws GlobalExceptionHandler;
   void validateUserSignUp(UserDTO user) throws GlobalExceptionHandler;
   void validateChangePassword(ForgetPWDDTO user) throws GlobalExceptionHandler;
}
