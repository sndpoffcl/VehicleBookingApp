package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    int id;
    @Column(nullable = false)
    String locationName;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    String pinCode;
    @ManyToOne
    City city;
    @OneToMany(mappedBy = "locationWithVehicle" , fetch = FetchType.LAZY)
    List<Vehicle> vehicleList;
    @OneToMany(mappedBy = "locationWithBooking" , fetch = FetchType.LAZY)
    List<Booking> bookingList;
}
