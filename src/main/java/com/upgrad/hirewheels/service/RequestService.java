package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.AdminRequestDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.entities.Vehicle;


public interface RequestService {
    Vehicle addVehicleRequest(VehicleDTO vehicle);
}
