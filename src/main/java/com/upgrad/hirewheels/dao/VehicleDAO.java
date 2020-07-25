package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("vehicleDAO")
public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {
   boolean existsByVehicleNumber(String VehicleNumber);
}
