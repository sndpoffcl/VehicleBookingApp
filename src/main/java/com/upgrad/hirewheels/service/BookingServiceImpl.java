package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.BookingDAO;
import com.upgrad.hirewheels.dao.LocationDAO;
import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.responsemodel.BookingHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    @Qualifier("bookingDAO")
    BookingDAO bookingDAO;

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Autowired
    @Qualifier("locationDAO")
    LocationDAO locationDAO;

    @Autowired
    @Qualifier("vehicleDAO")
    VehicleDAO vehicleDAO;

    /**
     * Helps in adding a bookingDTO for a Vehicle with respect to valid userId,LocationId and BookingId
     * @param bookingDTO
     * @return
     */

    public Booking addBooking(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setAmount(bookingDTO.getAmount());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setPickUpDate(bookingDTO.getPickupDate());
        booking.setDropOffDate(bookingDTO.getDropoffDate());
        booking.setBookingWithUser(userDAO.findById(bookingDTO.getUserId()).get());
        User user = userDAO.findById(bookingDTO.getUserId()).get();
        if (user.getWalletMoney() < bookingDTO.getAmount()) {
            throw new APIException("InSufficient Balance. Please Check With Admin.");
        } else {
            user.setWalletMoney(user.getWalletMoney() - bookingDTO.getAmount());
            userDAO.save(user);
        }
        booking.setLocationWithBooking(locationDAO.findById(bookingDTO.getLocationId()).get());
        booking.setVehicleWithBooking(vehicleDAO.findById(bookingDTO.getVehicleId()).get());
        Booking savedBooking = bookingDAO.save(booking);
        return savedBooking;
    }

    /**
     * Returns the booking history of user
     * @param userId
     * @return
     */

    @Override
    public List<BookingHistoryResponse> bookingHistory(int userId) {
        List<BookingHistoryResponse> bookingHistoryResponseList = new ArrayList<>();
        userDAO.findById(userId).get().getBookingList().forEach(a-> {
            BookingHistoryResponse bookingHistoryResponse = new BookingHistoryResponse();
            bookingHistoryResponse.setBookingId(a.getId());
            bookingHistoryResponse.setBookingDate(a.getBookingDate());
            bookingHistoryResponse.setDropOffDate(a.getDropOffDate());
            bookingHistoryResponse.setPickUpDate(a.getPickUpDate());
            bookingHistoryResponse.setAmount(a.getAmount());
            bookingHistoryResponse.setVehicleId(a.getVehicleWithBooking().getId());
            bookingHistoryResponse.setVehicleNumber(a.getVehicleWithBooking().getVehicleNumber());
            bookingHistoryResponse.setVehicleModel(a.getVehicleWithBooking().getVehicleModel());
            bookingHistoryResponse.setLocationName(a.getLocationWithBooking().getLocationName());
            bookingHistoryResponse.setCarImageUrl(a.getVehicleWithBooking().getCarImageUrl());
            bookingHistoryResponseList.add(bookingHistoryResponse);
        });
        return bookingHistoryResponseList;
    }

}
