package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.CustomResponse;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @PostMapping("/users")
    public ResponseEntity acceptUserDetails(@RequestBody UserDTO userDTO) throws GlobalExceptionHandler {
        ResponseEntity responseEntity = null;
        try {
            userValidator.validateUserSignUp(userDTO);
            User functionReturn = userService.createUser(userDTO);
            if (functionReturn != null) {
                CustomResponse response = new CustomResponse(new Date(), "User Successfully Signed Up", 200);
                responseEntity = new ResponseEntity(response, HttpStatus.OK);
            }
        }
        catch (GlobalExceptionHandler e){
            e.printStackTrace();
        }
        return responseEntity;
    }

    @PutMapping("/users/access-token/password")
    public ResponseEntity updateForgotPassword(@RequestBody ForgetPWDDTO forgetPWDDTO) throws GlobalExceptionHandler {
        ResponseEntity responseEntity = null;
            userValidator.validateChangePassword(forgetPWDDTO);
            if(userService.updatePassword(forgetPWDDTO)){
                CustomResponse response = new CustomResponse(new Date(), "User password successfully changed", 200);
                responseEntity = new ResponseEntity(response, HttpStatus.OK);
            }else{
                throw new APIException("Invalid operation");
            }
        return responseEntity;
    }

}
