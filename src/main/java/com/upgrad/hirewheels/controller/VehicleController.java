package com.upgrad.hirewheels.controller;


import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.service.VehicleService;
import com.upgrad.hirewheels.validator.VehicleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    UserService userService;

    @Autowired
    VehicleValidator vehicleValidator;

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @GetMapping("/vehicles")
    public ResponseEntity getAvailableVehicles(@RequestParam("categoryName") String categoryName, @RequestParam("pickUpDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date pickupDate,
                                               @RequestParam("dropDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dropDate, @RequestParam("locationId") int locationId){
        ResponseEntity responseEntity = null;
        try{
            vehicleValidator.validategetAllVehicles(categoryName,pickupDate, dropDate, locationId);
            List<VehicleDetailResponse> vehicleDetailResponse = vehicleService.getAvailableVehicles(categoryName, pickupDate, dropDate, locationId);
            responseEntity =  ResponseEntity.ok(vehicleDetailResponse);
        } catch (ParseException | GlobalExceptionHandler e) {
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/users/{userId}/vehicles")
    public ResponseEntity getVehicleByUserId(@PathVariable int userId){
        ResponseEntity responseEntity = null;
        try {
            vehicleValidator.validateUser(userId);
            List<VehicleDetailResponse> vehicleDetailResponse = vehicleService.getAllVehicleByUserId(userId);
            responseEntity =  ResponseEntity.ok(vehicleDetailResponse);
        } catch (GlobalExceptionHandler e) {
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

}
