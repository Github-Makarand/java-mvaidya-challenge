package com.example.rqchallenge.employees;


public class RQResponse<T> {

    public String status;
    public T data;
    public String message;

    public RQResponse(T returnValue) {
        status = "success";
        data = returnValue;
        message = null;
    }

    public RQResponse(String _status, T returnValue, String _message) {
        status = _status;
        data = returnValue;
        message = _message;
    }

}
