package com.upgrad.hirewheels.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    int userId;
    int vehicleId;
    Date pickupDate;
    Date dropoffDate;
    Date bookingDate;
    int locationId;
    int amount;
}
