package com.upgrad.hirewheels.controller;


import com.upgrad.hirewheels.dto.AdminActivityDTO;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.AdminRequestResponse;
import com.upgrad.hirewheels.responsemodel.CustomResponse;
import com.upgrad.hirewheels.service.AdminService;
import com.upgrad.hirewheels.validator.AdminValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminValidator adminValidator;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

}
