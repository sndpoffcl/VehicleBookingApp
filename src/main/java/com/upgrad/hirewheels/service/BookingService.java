package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.advice.GlobalExceptionHandler;
import com.upgrad.hirewheels.responsemodel.BookingHistoryResponse;

import java.util.List;

public interface BookingService {
    Booking addBooking(BookingDTO booking) throws GlobalExceptionHandler;
    List<BookingHistoryResponse> bookingHistory(int userId) throws GlobalExceptionHandler;
}
