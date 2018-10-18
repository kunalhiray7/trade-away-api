package com.tw.codeavengers.tradeawayapi.service;

import java.util.ArrayList;
import java.util.List;

public class Errors{
    private List<Error> errors = new ArrayList<>();

    public List<Error> getErrors() {
        return errors;
    }


    public void add(String field, String message){
        errors.add(new Error(field, message));

    }

    public class Error{
        private String field;
        private String defaultMessage;

        public Error(String field, String defaultMessage) {
            this.field = field;
            this.defaultMessage = defaultMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }
    }
}
