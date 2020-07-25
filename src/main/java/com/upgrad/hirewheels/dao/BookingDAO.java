package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookingDAO")
public interface BookingDAO extends JpaRepository<Booking, Integer> {
 List<Booking> findByVehicleWithBooking(Vehicle vehicle);
}
