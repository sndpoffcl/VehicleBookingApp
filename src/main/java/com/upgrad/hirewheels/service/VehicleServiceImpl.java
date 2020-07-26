package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.constants.ActivityEnum;
import com.upgrad.hirewheels.constants.StatusEnum;
import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.AdminRequest;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.responsemodel.VehicleDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    @Qualifier("vehicleCategoryDAO")
    VehicleCategoryDAO vehicleCategoryDAO;

    @Autowired
    @Qualifier("requestStatusDAO")
    RequestStatusDAO requestStatusDAO;

    @Autowired
    @Qualifier("bookingDAO")
    BookingDAO bookingDAO;



    /**
     * Returns all the available vehicle in the requested Category for booking with respect to Date, Location and Availability.
     * @param categoryName
     * @param pickUpDate
     * @param dropDate
     * @param locationId
     * @return
     */

    public List<VehicleDetailResponse> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) {
        List<Vehicle> returnedVehicleList = new ArrayList<>();
                vehicleCategoryDAO.findByVehicleCategoryName(categoryName).getVehicleSubCategoriesList().forEach(a-> a.getVehicleList().forEach(b-> {
                    if (b.getLocationWithVehicle().getId() == locationId) {
                        returnedVehicleList.add(b);
                    }
            }));
            // finding all vehicles under categoryName
            // matching vehicles with locationId
            // add matched vehicle to list


        List<Integer> bookedVehicleIdList = new ArrayList<>();
        returnedVehicleList.forEach(a-> {
            List<Booking> bookedVehicleList = bookingDAO.findByVehicleWithBooking(a);
            bookedVehicleList.forEach(b ->{
                if ((pickUpDate.after(b.getPickUpDate()) && pickUpDate.before(b.getDropOffDate())) || (dropDate.after(b.getPickUpDate()) && dropDate.before(b.getDropOffDate())) || (pickUpDate.before(b.getPickUpDate()) && dropDate.after(b.getDropOffDate())) || pickUpDate.equals(b.getDropOffDate()) || dropDate.equals(b.getPickUpDate()) || pickUpDate.equals(b.getPickUpDate()) || dropDate.equals(b.getDropOffDate())){
                    bookedVehicleIdList.add(b.getVehicleWithBooking().getId());
                }
            });
        });
       // List<Integer> approvedVehicles = requestStatusDAO.findById(StatusEnum.APPROVED.getValue()).get().getAdminRequestList().stream().filter(a -> a.getActivity().getId() != ActivityEnum.CAR_OPT_OUT.getValue()).map(AdminRequest::getVehicle).map(Vehicle::getId).collect(Collectors.toList());
        List<VehicleDetailResponse> mapVehicle = new ArrayList<>();
        for (Vehicle v : returnedVehicleList) {
            //if (approvedVehicles.contains(v.getId())) {
                if(!bookedVehicleIdList.contains(v.getId())){
                    VehicleDetailResponse vehicleDetailResponse = new VehicleDetailResponse();
                    vehicleDetailResponse.setVehicleId(v.getId());
                    vehicleDetailResponse.setVehicleModel(v.getVehicleModel());
                    vehicleDetailResponse.setVehicleOwnerId(v.getUser().getId());
                    vehicleDetailResponse.setVehicleOwnerName(v.getUser().getFirstName());
                    vehicleDetailResponse.setVehicleNumber(v.getVehicleNumber());
                    vehicleDetailResponse.setColor(v.getColor());
                    vehicleDetailResponse.setCostPerHour(v.getVehicleSubCategory().getPricePerHour());
                    vehicleDetailResponse.setFuelType(v.getFuelType().getFuelType());
                    vehicleDetailResponse.setLocationId(v.getLocationWithVehicle().getId());
                    vehicleDetailResponse.setCarImageUrl(v.getCarImageUrl());
                    vehicleDetailResponse.setActivityId(v.getAdminRequest().getActivity().getId());
                    vehicleDetailResponse.setRequestStatusId(v.getAdminRequest().getRequestStatus().getId());
                    vehicleDetailResponse.setVehicleSubCategoryId(v.getVehicleSubCategory().getId());
                    mapVehicle.add(vehicleDetailResponse);
                }
            //}
        }
       return mapVehicle;
    }




}

