package com.tw.codeavengers.tradeawayapi.web;

import com.tw.codeavengers.tradeawayapi.service.Errors;
import com.tw.codeavengers.tradeawayapi.service.FieldValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(FieldValidationException.class)
    public ResponseEntity<Errors> handleValidationExceptions(FieldValidationException e){
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
