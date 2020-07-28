package com.upgrad.hirewheels.util;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOMapper {

    public VehicleDetailResponse convertToVehicleResponse(Vehicle vehicle){
        VehicleDetailResponse vehicleDetailResponse = new VehicleDetailResponse();
        vehicleDetailResponse.setCarImageUrl(vehicle.getCarImageUrl());
        vehicleDetailResponse.setColor(vehicle.getColor());
        //.....all other fiels
        return vehicleDetailResponse;
    }
}
