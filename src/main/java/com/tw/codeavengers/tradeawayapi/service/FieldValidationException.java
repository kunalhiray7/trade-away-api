package com.tw.codeavengers.tradeawayapi.service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class FieldValidationException extends ValidationException{
    private Errors errors = new Errors();

    public FieldValidationException(String message, String fieldName) {
        super(message);
        errors.add(fieldName, message);
    }

    public Errors getErrors() {
        return errors;
    }
}
