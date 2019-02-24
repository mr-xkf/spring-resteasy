package com.example.demo.exception;

public interface CommonError {

     Integer getErrorCode();

     String getErrorMsg();

     CommonError setMsg(String message);
}
