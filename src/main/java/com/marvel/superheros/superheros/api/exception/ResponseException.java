package com.marvel.superheros.superheros.api.exception;

public abstract class ResponseException extends BaseException {

    protected ResponseException(int code, String message, String errorCode) {
        super(code, message, errorCode);
    }

    protected ResponseException(int code, String message, String errorCode, Throwable cause) {
        super(code, message, errorCode, cause);
    }
}
