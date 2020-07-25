package com.upgrad.hirewheels.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    int id;
    @Column(nullable = false)
    String firstName;
    String lastName;
    @Column( nullable = false)
    String password;
    @Column( nullable = false, unique = true)
    String email;
    @Column( nullable = false, unique = true)
    String mobileNo;
    int walletMoney;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    UserRole userRole;

    @OneToMany(mappedBy = "bookingWithUser" , fetch = FetchType.LAZY)
    List<Booking> bookingList;
}