package com.example.order.exception;

import com.example.order.exception.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class OrderServiceException extends RuntimeException {
    private final HttpStatus status;
    private final String code;
    private final String message;

    public OrderServiceException(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
    }
}
