package com.marvel.superheros.superheros.util;

import lombok.Getter;

public class Constants {

    @Getter
    public enum ErrorCodeEnum {
        ERR_3011("Error saving Hero.");

        private String message;

        ErrorCodeEnum(String message) {
            this.message = message;
        }

        public String getErrorCode() {
            return this.name().replace("_", "-");
        }

    }
}
