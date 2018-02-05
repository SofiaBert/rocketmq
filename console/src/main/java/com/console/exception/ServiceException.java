package com.console.exception;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 9213584003139969215L;
    private int code;

    public ServiceException( int code,String message) {
        super(message);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
