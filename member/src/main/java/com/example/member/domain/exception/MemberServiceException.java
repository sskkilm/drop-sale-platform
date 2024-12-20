package com.example.member.domain.exception;

import lombok.Getter;

@Getter
public class MemberServiceException extends RuntimeException {

    private final ErrorCode errorCode;

    public MemberServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public MemberServiceException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
}
