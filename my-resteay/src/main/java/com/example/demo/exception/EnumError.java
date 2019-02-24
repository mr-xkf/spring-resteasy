package com.example.demo.exception;

public enum EnumError  implements CommonError{

    PARAM_UNKONW(10001,"参数未知!"),
    NULL_OBJECT(10002,"对象为空！");

    private Integer code;

    private String message;

    EnumError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.message;
    }

    @Override
    public CommonError setMsg(String message) {
        this.message = message;
        return this;
    }
}
