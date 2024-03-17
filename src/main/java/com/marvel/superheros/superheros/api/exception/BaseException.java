package com.marvel.superheros.superheros.api.exception;

import lombok.Getter;

@Getter
public class BaseException extends Exception {

    private final int code;
    private final String description;
    private final String errorCode;

    public BaseException(int code, String message, String errorCode) {
        super(message);
        this.code = code;
        this.description = message;
        this.errorCode = errorCode;
    }

    public BaseException(int code, String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.description = message;
        this.errorCode = errorCode;
    }
}
