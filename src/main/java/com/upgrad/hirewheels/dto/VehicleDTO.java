package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class VehicleDTO {
     String vehicleModel;
     String vehicleNumber;
     int vehicleSubCategoryId;
     String color;
     int fuelTypeId;
     int locationId;
     String carImageUrl;
     String userComments;
     int userId;
}
