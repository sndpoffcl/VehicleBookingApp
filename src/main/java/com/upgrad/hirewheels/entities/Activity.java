package com.upgrad.hirewheels.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ACTIVITY")
public class Activity {
    @Id
    int id;
    @Column(unique = true, nullable = false)
    String activityType;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
    @JsonManagedReference
    List<AdminRequest> adminRequestList;
}

