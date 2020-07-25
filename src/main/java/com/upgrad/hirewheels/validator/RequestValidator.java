package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.AdminRequestDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;

public interface RequestValidator {
    void validateChangeVehicleAvailability(AdminRequestDTO vehicle, int vehicleId) throws GlobalExceptionHandler;
    void validateAddVehicleRequest(VehicleDTO vehicleDTO) throws GlobalExceptionHandler;
}
