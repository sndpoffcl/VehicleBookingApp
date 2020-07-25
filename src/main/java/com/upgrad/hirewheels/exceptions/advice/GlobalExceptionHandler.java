package com.upgrad.hirewheels.exceptions.advice;


import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserNotFoundException;
import com.upgrad.hirewheels.responsemodel.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;


@ControllerAdvice
public class GlobalExceptionHandler extends Exception{

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRunTimeException(RuntimeException ex) {
        return error(BAD_REQUEST, ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return error(UNAUTHORIZED, ex);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> handleAPIException(APIException ex) {
        return error(BAD_REQUEST, ex);
    }

    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public ResponseEntity<Object> handle(Exception ex) {
        logger.error("Exception : ", ex);
        return error(BAD_REQUEST, ex);
    }

    private ResponseEntity error(HttpStatus status, Exception ex) {
        logger.error("Exception : ", ex);
        CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), status.value());
        return new ResponseEntity(customResponse, status);
    }

}
