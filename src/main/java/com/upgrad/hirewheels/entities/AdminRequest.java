package com.upgrad.hirewheels.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADMINREQUEST")
public class AdminRequest {
    @Id
    @GeneratedValue
    int id;
    String userComments;
    String adminComments;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonBackReference
    RequestStatus requestStatus;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonBackReference
    User user;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonBackReference
    Activity activity;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonBackReference
    Vehicle vehicle;
}
