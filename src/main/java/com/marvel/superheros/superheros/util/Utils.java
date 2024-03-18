package com.marvel.superheros.superheros.util;

import com.marvel.superheros.superheros.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class Utils {

    public static ErrorDTO getErrorDTO(HttpStatus status, String message) {
        return ErrorDTO.builder()
                .timestamp(System.currentTimeMillis())
                .error(String.valueOf(status))
                .message(message)
                .build();
    }
}
