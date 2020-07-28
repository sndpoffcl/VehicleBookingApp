package com.upgrad.hirewheels.responsemodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class CustomResponse {
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
