package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.AdminActivityDTO;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;

public interface AdminValidator {
    void validateGetAllApprovals(int requestId) throws GlobalExceptionHandler;
    void validateUpdateVehicleRequest(AdminActivityDTO vehicle, int requestId) throws GlobalExceptionHandler;
}
