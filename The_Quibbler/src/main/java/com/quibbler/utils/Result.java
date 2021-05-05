package com.quibbler.utils;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 返回统一接口封装
 *
 * @author paksu
 */
@Data
public class Result implements Serializable{

    private static final long serialVersionUID = 3793358156833487817L;

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String DATA = "data";
    private static final String MESSAGE = "message";

    private Object code;
    private String message;
    private Object data;


    public static Result result(Object code,Object data) {
        return resultWithData(code, data);
    }

    private static Result resultWithData(Object code,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    private static Result resultWithMessage(Object code,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    private static Result resultWithDataAndMessage(Object code,Object data,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static Result successWithData(Object data) {
        return resultWithData(SUCCESS, data);
    }

    public static Result successWithMessage(String message) {
        return resultWithMessage(SUCCESS, message);
    }

    public static Result successWithDataAndMessage(Object data, String message) {
        return resultWithDataAndMessage(SUCCESS, data, message);
    }

    public static Result errorWithData(Object data) {
        return resultWithData(ERROR, data);
    }

    public static Result errorWithMessage(Object data,String message) {
        return resultWithDataAndMessage(ERROR, data, message);
    }

    public static Result errorWithDataAndMessage(Object data,String message) {
        return resultWithDataAndMessage(ERROR, data, message);
    }
}
