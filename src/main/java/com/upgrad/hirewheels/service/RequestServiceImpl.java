package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.constants.ActivityEnum;
import com.upgrad.hirewheels.constants.StatusEnum;
import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.dto.AdminRequestDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Autowired
    @Qualifier("activityDAO")
    ActivityDAO activityDAO;

    @Autowired
    @Qualifier("vehicleSubCategoryDAO")
    VehicleSubCategoryDAO vehicleSubCategoryDAO;

    @Autowired
    @Qualifier("fuelTypeDAO")
    FuelTypeDAO fuelTypeDAO;

    @Autowired
    @Qualifier("requestStatusDAO")
    RequestStatusDAO requestStatusDAO;

    @Autowired
    @Qualifier("vehicleDAO")
    VehicleDAO vehicleDAO;

    @Autowired
    @Qualifier("locationDAO")
    LocationDAO locationDAO;

    @Autowired
    @Qualifier("adminRequestDAO")
    AdminRequestDAO adminRequestDAO;


    /**
     * Helps to register a vehicle. Vehicle is auto approved if added by Admin. If added by admin, goes as a request for the Admin to approve.
     * @param vehicleDTO
     * @return
     */
    public Vehicle addVehicleRequest(VehicleDTO vehicleDTO) {
        boolean testVehicleNumber = vehicleDAO.existsByVehicleNumber(vehicleDTO.getVehicleNumber());
        if (testVehicleNumber) {
            throw new APIException("Vehicle Number Already Exists");
        }
        Vehicle vehicle = new Vehicle();
        AdminRequest adminRequest = new AdminRequest();
        vehicle.setVehicleModel(vehicleDTO.getVehicleModel());
        vehicle.setUser(userDAO.findById(vehicleDTO.getUserId()).get());
        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setFuelType(fuelTypeDAO.findById(vehicleDTO.getFuelTypeId()).get());
        vehicle.setCarImageUrl(vehicleDTO.getCarImageUrl());
        vehicle.setLocationWithVehicle(locationDAO.findById(vehicleDTO.getLocationId()).get());
        vehicle.setVehicleSubCategory(vehicleSubCategoryDAO.findById(vehicleDTO.getVehicleSubCategoryId()).get());
        Vehicle vehicle1 = vehicleDAO.save(vehicle);
        adminRequest.setActivity(activityDAO.findById(ActivityEnum.VEHICLE_REGISTER.getValue()).get());
        adminRequest.setUser(userDAO.findById(vehicleDTO.getUserId()).get());
        if (vehicleDTO.getUserId() != 1) {
            adminRequest.setRequestStatus(requestStatusDAO.findById(StatusEnum.PENDING.getValue()).get());
            adminRequest.setUserComments(vehicleDTO.getUserComments());
            adminRequest.setVehicle(vehicle1);
            adminRequestDAO.save(adminRequest);
        } else {
            adminRequest.setRequestStatus(requestStatusDAO.findById(StatusEnum.APPROVED.getValue()).get());
            adminRequest.setAdminComments("Approved as added by Admin");
            adminRequest.setVehicle(vehicle1);
            adminRequestDAO.save(adminRequest);
        }
        return vehicle;
    }
}
