package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.CustomResponse;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AuthenticationController{

    @Autowired
    UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserValidator userValidator;


    @PostMapping("/users")
    public ResponseEntity userSignUp(@RequestBody UserDTO userDTO) throws GlobalExceptionHandler {
        ResponseEntity responseEntity = null;
            userValidator.validateUserSignUp(userDTO);
            User functionReturn = userService.createUser(userDTO);
            if (functionReturn != null) {
                CustomResponse response = new CustomResponse(new Date(), "User Successfully Signed Up", 200);
                responseEntity = new ResponseEntity(response, HttpStatus.OK);
            }
        return responseEntity;
    }

    @PutMapping("/users/password")
    public ResponseEntity changePassword(@RequestBody ForgetPWDDTO forgetPWDDTO) throws GlobalExceptionHandler {
        ResponseEntity responseEntity = null;
            userValidator.validateChangePassword(forgetPWDDTO);
            boolean functionReturn = userService.updatePassword(forgetPWDDTO);
            if (functionReturn == true) {
                CustomResponse response = new CustomResponse(new Date(), "Password Successfully Changed", 200);
                return new ResponseEntity(response, HttpStatus.OK);
            }
        return responseEntity;
    }
}
