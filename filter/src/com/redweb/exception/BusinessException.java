package com.redweb.exception;

/**
 * Created by 11407 on 2017/3/8.
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = -3040955562136599570L;

    public BusinessException(String msg) {
        super(msg);
    }
}
