package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.VehicleSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleSubCategoryDAO")
public interface VehicleSubCategoryDAO extends JpaRepository<VehicleSubCategory, Integer> {
}
