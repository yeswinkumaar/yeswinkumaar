package com.bms.loanservice.common;

public class APIError {

    private String status;

    private int statusCode;

    private String message;

    public APIError(){}

    public APIError(String status, int statusCode, String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "APIError{" +
                "status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}
