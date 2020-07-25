package com.upgrad.hirewheels.responsemodel;

import lombok.Data;

import java.util.Date;

@Data
public class BookingHistoryResponse {
    int bookingId;
    Date pickUpDate;
    Date dropOffDate;
    Date bookingDate;
    int amount;
    int vehicleId;
    String vehicleModel;
    String vehicleNumber;
    String carImageUrl;
    String locationName;
}
