package com.esd.project.faculty.faculty_modification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcaptionHandler {
    @ExceptionHandler({BusinessExaception.class })
    public ResponseEntity<ApiResponse> hadleCustomException(BusinessExaception e) {
        ApiResponse res = new ApiResponse();
        res.setMessage(e.getMessage());
        res.setReason(e.getMessage());
        res.setErrorCode(400);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

}
