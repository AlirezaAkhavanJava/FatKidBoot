package com.arcade.FatKidBoot.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {
    private LocalDateTime timestamp;  // when this happened
    private int status;               // numeric status (404)
    private String error;             // HttpStatus.NOT_FOUND.name()
    private String message;           // custom message
    private String path;

}
