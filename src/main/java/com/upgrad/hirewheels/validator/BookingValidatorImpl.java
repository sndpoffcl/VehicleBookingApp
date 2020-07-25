package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.exceptions.APIException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BookingValidatorImpl implements BookingValidator {



    @Override
    public void validateBooking(BookingDTO vehicle) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(new Date());
        Date todaysDate = sdf.parse(dateString);
        String formatBookingDate = sdf.format(vehicle.getBookingDate());
        Date parsedBookingDate = sdf.parse(formatBookingDate);
        String formatPickUpDate = sdf.format(vehicle.getPickupDate());
        Date parsedPickUpDate = sdf.parse(formatPickUpDate);
        String formatDropOffDate = sdf.format(vehicle.getDropoffDate());
        Date parsedDropOffDate = sdf.parse(formatDropOffDate);
        if (vehicle.getUserId() == 0 || vehicle.getAmount() == 0|| vehicle.getLocationId() == 0 || vehicle.getVehicleId() == 0){
            throw new APIException("User/Amount/Location/Vehicle ID can't be empty");
        }
        if (todaysDate.compareTo(parsedBookingDate) != 0){
            throw new APIException("Booking date should be today's date");
        }
        if (todaysDate.compareTo(parsedDropOffDate) != -1 || parsedPickUpDate.compareTo(parsedDropOffDate) != -1){
            throw new APIException("DropDate should be greater than today's date and greater than PickUp Date");
        }
        if (todaysDate.compareTo(parsedPickUpDate) == 1){
            throw new APIException("PickUpDate should not be less than today's date");
        }
    }

    @Override
    public void validateBookingHistory(int userId) {
        if (userId == 0){
            throw new APIException("User Id Id can't be empty");
        }
    }
}
