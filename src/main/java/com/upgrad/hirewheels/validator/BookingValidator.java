package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dto.BookingDTO;

import java.text.ParseException;

public interface BookingValidator {
    void validateBooking(BookingDTO vehicle) throws ParseException;
    void validateBookingHistory(int userId);
}
