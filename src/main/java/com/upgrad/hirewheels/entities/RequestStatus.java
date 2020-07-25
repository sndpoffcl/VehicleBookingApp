package com.upgrad.hirewheels.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="REQUESTSTATUS")
public class RequestStatus {
    @Id
    int id;
    @Column(unique = true, nullable = false)
    String requestStatusName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "requestStatus")
    @JsonManagedReference
    List<AdminRequest> adminRequestList;
}
