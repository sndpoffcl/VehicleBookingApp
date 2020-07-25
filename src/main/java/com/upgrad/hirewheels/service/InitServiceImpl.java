package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    @Qualifier("userRoleDAO")
    UserRoleDAO userRoleDAO;

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @Autowired
    @Qualifier("activityDAO")
    ActivityDAO activityDAO;

    @Autowired
    @Qualifier("vehicleCategoryDAO")
    VehicleCategoryDAO vehicleCategoryDAO;

    @Autowired
    @Qualifier("vehicleSubCategoryDAO")
    VehicleSubCategoryDAO vehicleSubCategoryDAO;

    @Autowired
    @Qualifier("cityDAO")
    CityDAO cityDAO;

    @Autowired
    @Qualifier("fuelTypeDAO")
    FuelTypeDAO fuelTypeDAO;

    @Autowired
    @Qualifier("requestStatusDAO")
    RequestStatusDAO requestStatusDAO;

    @Autowired
    @Qualifier("vehicleDAO")
    VehicleDAO vehicleDAO;

    @Autowired
    @Qualifier("locationDAO")
    LocationDAO locationDAO;

    @Autowired
    @Qualifier("adminRequestDAO")
    AdminRequestDAO adminRequestDAO;


    @Autowired
    @Qualifier("bookingDAO")
    BookingDAO bookingDAO;


    public void start() {
        addUserRole();
        addUsers();
        addActivity();
        addVehicleCategory();
        addVehicleSubCategory();
        addCity();
        addFuelType();
        addRequestStatus();
        addLocation();
    }

    private void addLocation() {
        Location location = new Location();
        location.setId(1);
        location.setLocationName("Worli");
        location.setAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location.setId(400018);
        location.setCity(cityDAO.findById(1).get());
        locationDAO.save(location);
    }

    private void addRequestStatus() {
        List<RequestStatus> requestStatusList = new ArrayList<>();
        RequestStatus requestStatus1 = new RequestStatus();
        requestStatus1.setId(301);
        requestStatus1.setRequestStatusName("PENDING");
        requestStatusList.add(requestStatus1);
        RequestStatus requestStatus2 = new RequestStatus();
        requestStatus2.setId(302);
        requestStatus2.setRequestStatusName("APPROVED");
        requestStatusList.add(requestStatus2);
        RequestStatus requestStatus3 = new RequestStatus();
        requestStatus3.setId(303);
        requestStatus3.setRequestStatusName("REJECTED");
        requestStatusList.add(requestStatus3);
        requestStatusDAO.saveAll(requestStatusList);
    }

    private void addFuelType() {
        List<FuelType> fuelTypeList = new ArrayList<>();
        FuelType fuelType1 = new FuelType();
        fuelType1.setFuelType("Petrol");
        fuelType1.setId(1);
        fuelTypeList.add(fuelType1);
        FuelType fuelType2 = new FuelType();
        fuelType2.setFuelType("Diesel");
        fuelType2.setId(2);
        fuelTypeList.add(fuelType2);
        fuelTypeDAO.saveAll(fuelTypeList);
    }

    private void addCity() {
        City city = new City();
        city.setId(1);
        city.setCityName("Mumbai");
        cityDAO.save(city);
    }

    private void addVehicleSubCategory() {
        List<VehicleSubCategory> vehicleSubCategories = new ArrayList<>();
        VehicleSubCategory vehicleSubCategory1 = new VehicleSubCategory();
        vehicleSubCategory1.setId(1);
        vehicleSubCategory1.setVehicleSubCategoryName("SUV");
        vehicleSubCategory1.setPricePerHour(300);
        vehicleSubCategory1.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory1);
        VehicleSubCategory vehicleSubCategory2 = new VehicleSubCategory();
        vehicleSubCategory2.setId(2);
        vehicleSubCategory2.setVehicleSubCategoryName("SEDAN");
        vehicleSubCategory2.setPricePerHour(350);
        vehicleSubCategory2.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory2);
        VehicleSubCategory vehicleSubCategory3 = new VehicleSubCategory();
        vehicleSubCategory3.setId(3);
        vehicleSubCategory3.setVehicleSubCategoryName("HATCHBACK");
        vehicleSubCategory3.setPricePerHour(250);
        vehicleSubCategory3.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory3);
        VehicleSubCategory vehicleSubCategory4 = new VehicleSubCategory();
        vehicleSubCategory4.setId(4);
        vehicleSubCategory4.setVehicleSubCategoryName("CRUISER");
        vehicleSubCategory4.setPricePerHour(200);
        vehicleSubCategory4.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory4);
        VehicleSubCategory vehicleSubCategory5 = new VehicleSubCategory();
        vehicleSubCategory5.setId(5);
        vehicleSubCategory5.setVehicleSubCategoryName("DIRT BIKE");
        vehicleSubCategory5.setPricePerHour(200);
        vehicleSubCategory5.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory5);
        VehicleSubCategory vehicleSubCategory6 = new VehicleSubCategory();
        vehicleSubCategory6.setId(6);
        vehicleSubCategory6.setVehicleSubCategoryName("SPORTS BIKE");
        vehicleSubCategory6.setPricePerHour(150);
        vehicleSubCategory6.setVehicleCategory(vehicleCategoryDAO.findById(10).get());
        vehicleSubCategories.add(vehicleSubCategory6);
        vehicleSubCategoryDAO.saveAll(vehicleSubCategories);
    }

    private void addVehicleCategory() {
        List<VehicleCategory> vehicleCategoryList = new ArrayList<>();
        VehicleCategory vehicleCategory1 = new VehicleCategory();
        vehicleCategory1.setId(10);
        vehicleCategory1.setVehicleCategoryName("CAR");
        vehicleCategoryList.add(vehicleCategory1);
        VehicleCategory vehicleCategory2 = new VehicleCategory();
        vehicleCategory2.setId(11);
        vehicleCategory2.setVehicleCategoryName("BIKE");
        vehicleCategoryList.add(vehicleCategory2);
        vehicleCategoryDAO.saveAll(vehicleCategoryList);
    }

    private void addActivity() {
        List<Activity> listOfActivity = new ArrayList<>();
        Activity activity1 = new Activity();
        activity1.setId(201);
        activity1.setActivityType("VEHICLE_REGISTER");
        listOfActivity.add(activity1);
        Activity activity2 = new Activity();
        activity2.setId(202);
        activity2.setActivityType("CAR_OPT_IN");
        listOfActivity.add(activity2);
        Activity activity3 = new Activity();
        activity3.setId(203);
        activity3.setActivityType("CAR_OPT_OUT");
        listOfActivity.add(activity3);
        activityDAO.saveAll(listOfActivity);
    }

    private void addUsers() {
        User adminUser = new User();
        adminUser.setFirstName("Upgrad");
        adminUser.setLastName("Admim");
        adminUser.setEmail("upgrad@gmail.com");
        adminUser.setMobileNo("9898989890");
        adminUser.setPassword("admin@123");
        adminUser.setWalletMoney(10000);
        adminUser.setUserRole(userRoleDAO.findById(1).get());
        userDAO.save(adminUser);
    }

    private void addUserRole() {
        UserRole adminUserRole = new UserRole();
        adminUserRole.setId(1);
        adminUserRole.setRoleName("Admin");
        UserRole userRole = new UserRole();
        userRole.setId(2);
        userRole.setRoleName("User");
        userRoleDAO.save(adminUserRole);
        userRoleDAO.save(userRole);
    }

}
