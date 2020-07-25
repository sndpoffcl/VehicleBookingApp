package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;

import java.text.ParseException;
import java.util.Date;

public interface VehicleValidator {
    void validategetAllVehicles(String categoryName, Date pickupDate, Date dropDate, int locationId) throws GlobalExceptionHandler, ParseException;
    void validateUser(int userId) throws GlobalExceptionHandler;
}
