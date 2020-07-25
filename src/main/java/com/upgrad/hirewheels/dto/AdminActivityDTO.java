package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class AdminActivityDTO {
    int activityId;
    int requestStatusId;
    String adminComments;
    int userId;
}
