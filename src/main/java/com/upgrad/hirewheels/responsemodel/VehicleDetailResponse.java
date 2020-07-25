package com.upgrad.hirewheels.responsemodel;

import lombok.Data;

@Data
public class VehicleDetailResponse {
    int vehicleId;
    String vehicleModel;
    int vehicleOwnerId;
    String vehicleOwnerName;
    String vehicleNumber;
    String color;
    String fuelType;
    int locationId;
    String carImageUrl;
    int costPerHour;
    int activityId;
    int requestStatusId;
    int vehicleSubCategoryId;
}
