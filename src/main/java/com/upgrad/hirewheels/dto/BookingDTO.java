package com.upgrad.hirewheels.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    int userId;
    int vehicleId;
    Date pickupDate; // when the booking starts
    Date dropoffDate; // when the booking ends
    Date bookingDate; //when the booking was done
    int locationId;
    int amount;
}

    // open the app
    // add location , pick date , drop date
    // get ALl vehicles
    // bookings