package com.upgrad.hirewheels.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="BOOKING")
public class Booking {
    @Id
    @GeneratedValue
    int id;
    @Column( nullable = false)
    Date pickUpDate;
    @Column( nullable = false)
    Date dropOffDate;
    @Column( nullable = false)
    Date bookingDate;
    @Column( nullable = false)
    int amount;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    User bookingWithUser;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    Location locationWithBooking;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    Vehicle vehicleWithBooking;
}
