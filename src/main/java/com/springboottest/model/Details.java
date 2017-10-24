package com.springboottest.model;

/**
 * Created by Vijay.Ramineni on 22/10/2017.
 * This is for error details json model
 */
public class Details {

    private String location;
    private String param;
    private String msg;
    private String value;

    public Details(String location,String param,String msg,String value)
    {
        this.location=location;
        this.param=param;
        this.msg=msg;
        this.value=value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Details(String message)
    {
        this.message=message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

