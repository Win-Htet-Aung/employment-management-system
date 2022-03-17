package com.assignment.employeemanagement.error;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String errorcode;
    private String message;

    public ErrorResponse(String errorcode, String message) {
        this.errorcode = errorcode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorcode;
    }

    public void setErrorCode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
