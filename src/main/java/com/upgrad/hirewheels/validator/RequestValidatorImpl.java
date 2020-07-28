package com.upgrad.hirewheels.validator;

import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dto.AdminRequestDTO;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestValidatorImpl implements RequestValidator {

    List<Integer> activityIds = new ArrayList<>(Arrays.asList(202,203));

 @Autowired
 @Qualifier("userDAO")
 UserDAO userDAO;


 @Override
    public void validateChangeVehicleAvailability(AdminRequestDTO adminRequestDTO, int vehicleId) {
        if (vehicleId == 0){
            throw new APIException("Vehicle Id can't be empty");
        }
        if (adminRequestDTO.getUserId() == 0){
            throw new APIException("User Id can't be empty");
        }
        if (adminRequestDTO.getUserId() != 1) {
            List<Integer> vehicleIdList =  userDAO.findById(adminRequestDTO.getUserId()).get().getVehiclesList().stream().map(Vehicle::getId).collect(Collectors.toList());
            if (!vehicleIdList.contains(vehicleId)) {
                throw new APIException("Only Owner Can OptIn/OptOut Vehicle");
            }
        }
        if(!activityIds.contains(adminRequestDTO.getActivityId())){
            throw new APIException("Not a Valid Activity Id");
        }
    }


    @Override
    public void validateAddVehicleRequest(VehicleDTO vehicleDTO) {
        if(vehicleDTO.getVehicleNumber().isEmpty() || vehicleDTO.getVehicleNumber() == null || vehicleDTO.getVehicleModel().isEmpty() || vehicleDTO.getVehicleModel() == null || vehicleDTO.getColor().isEmpty() || vehicleDTO.getColor() == null ||vehicleDTO.getCarImageUrl().isEmpty() || vehicleDTO.getCarImageUrl() == null){
            throw new APIException("Vehicle Number/Vehicle Model/Color/CarImage URL cannot be null or empty");
        }
        if (vehicleDTO.getVehicleSubCategoryId() == 0 || vehicleDTO.getFuelTypeId() == 0 || vehicleDTO.getLocationId() == 0 || vehicleDTO.getUserId() == 0){
            throw new APIException("Sub-Category/Fuel/Location/User ID can't be empty");
        }

    }
}
