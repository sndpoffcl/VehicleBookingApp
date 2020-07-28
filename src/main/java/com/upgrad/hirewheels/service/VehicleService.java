package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    List<VehicleDetailResponse> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) throws GlobalExceptionHandler;
    List<VehicleDetailResponse> getAllVehicleByUserId(int userId) throws GlobalExceptionHandler;
}
