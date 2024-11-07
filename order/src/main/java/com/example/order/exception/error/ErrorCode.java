package com.example.order.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    ORDER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 주문입니다."),
    MEMBER_UN_MATCHED(HttpStatus.BAD_REQUEST, "회원 정보가 일치하지 않습니다"),
    CAN_NOT_BE_CANCELED(HttpStatus.BAD_REQUEST, "취소될 수 없는 주문입니다."),
    CAN_NOT_BE_RETURNED(HttpStatus.BAD_REQUEST, "반품될 수 없는 주문입니다."),
    TOTAL_AMOUNT_MIS_MATCH(HttpStatus.BAD_REQUEST, "총 주문 금액이 맞지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다.");

    private final HttpStatus status;
    private final String message;
}