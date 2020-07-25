package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.exceptions.APIException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;


@Service
public class UserValidatorImpl implements UserValidator {

    //To-DO:Can include isBlank validation if required.

    @Override
    public void validateuserLogin(LoginDTO user) {
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(user.getEmail())) {
            throw new APIException("Email Id Validation Error");
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()  || user.getPassword() == null || user.getPassword().isEmpty() ) {
            throw new APIException("Email/Password cannot be null or empty");
        }
    }

    @Override
    public void validateUserSignUp(UserDTO user){
        EmailValidator validator = EmailValidator.getInstance();
        if(user.getFirstName().isEmpty() || user.getFirstName() ==null){
            throw new APIException("FirstName cannot be null or empty");
        }
        if (user.getPassword().isEmpty() || user.getPassword() ==null || user.getPassword().length()<5){
            throw new APIException("Password cannot be null or empty or less than 5 characters");
        }
        if (!validator.isValid(user.getEmail())){
                        throw new APIException("Email Id Validation Error");
        }
        if (user.getMobileNo().isEmpty() || user.getMobileNo() == null || user.getMobileNo().length()<10 || user.getMobileNo().length()>10){
            throw new APIException("Mobile Number cannot be null or empty and must be 10 digits");
        }
    }

    @Override
    public void validateChangePassword(ForgetPWDDTO user){
        EmailValidator validator = EmailValidator.getInstance();
        if (user.getPassword().isEmpty() || user.getPassword() ==null || user.getPassword().length()<5){
            throw new APIException("Password cannot be null or empty or less than 5 characters");
        }else if (!validator.isValid(user.getEmail())){
            throw new APIException("Email Id Validation Error");
        }else if (user.getMobileNo().isEmpty() || user.getMobileNo() == null || user.getMobileNo().length()<10 || user.getMobileNo().length()>10){
            throw new APIException("Mobile Number cannot be null or empty and must be 10 digits");
        }
    }


}
