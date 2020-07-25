package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("requestStatusDAO")
public interface RequestStatusDAO extends JpaRepository<RequestStatus, Integer> {
}
