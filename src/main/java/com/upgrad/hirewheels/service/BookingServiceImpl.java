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

}
