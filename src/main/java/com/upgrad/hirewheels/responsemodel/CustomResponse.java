package com.upgrad.hirewheels.responsemodel;

import lombok.Data;

import java.util.Date;

@Data
public class CustomResponse {
    private Date timestamp;
    private String message;
    private int statusCode;

    public CustomResponse(Date timestamp, String message, int statusCode) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
    }
}
