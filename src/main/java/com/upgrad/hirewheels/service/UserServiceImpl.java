package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.UserRoleDAO;
import com.upgrad.hirewheels.dto.ForgetPWDDTO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UserDTO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.entities.UserRole;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotFoundException;
import com.upgrad.hirewheels.util.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Autowired
    @Qualifier("userRoleDAO")
    UserRoleDAO userRoleDAO;

    @Autowired
    DTOEntityMapper dtoEntityMapper;

    /**
     * Checks if the userDTO mobile number/email is already exists or not. If not exists, saves the userDTO detail else throws an error.
     * @param userDTO
     * @return saved userDTO details.
     */

    public User createUser(UserDTO userDTO) {
            User returnedUser = userDAO.findByEmail(userDTO.getEmail());
                if ( returnedUser != null) {
                    throw new UserAlreadyExistsException("Email Already Exists");
                }
            User returnedUser1 = userDAO.findByMobileNo(userDTO.getMobileNo());
            if (returnedUser1 != null) {
                throw new UserAlreadyExistsException("Mobile Number Already Exists");
                }
            User newUser = dtoEntityMapper.convertToUserEntity(userDTO);
            User savedUser = userDAO.save(newUser);
            return savedUser;
    }

    /**
     * Checks if the user is registered or not. If registered it checks the new password is not equal to the current password.
     * If the password os different, it updates the password else throws an error.
     * @param forgetPWDDTO
     * @return
     */

    public Boolean updatePassword(ForgetPWDDTO forgetPWDDTO) {
            User user = userDAO.findByEmailAndMobileNo(forgetPWDDTO.getEmail(), forgetPWDDTO.getMobileNo());
            if(user == null){
                throw new APIException("Invalid Email/Mobile Number");
            }
            String currentPassword = user.getPassword();
                if(user != null && !currentPassword.equals(forgetPWDDTO.getPassword())) {
                    user.setPassword(forgetPWDDTO.getPassword());
                    userDAO.save(user);
                    return true;
                } else {
                    throw new APIException("The new password should be different from the existing one");
                }
    }

}
