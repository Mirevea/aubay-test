package com.marvel.superheros.superheros.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO extends BaseDTO {
    private long timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
}
