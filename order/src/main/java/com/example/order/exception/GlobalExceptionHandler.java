package com.example.order.exception;

import com.example.order.exception.error.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.example.order.exception.error.ErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<?> handleOrderServiceException(OrderServiceException e) {
        log.info("Error Http Status: {}", e.getStatus());
        log.info("Error Code: {}", e.getCode());
        log.info("Error Code Message: {}", e.getMessage());
        return ResponseEntity
                .status(e.getStatus())
                .body(new ErrorResponse(e.getCode(), e.getMessage()));
    }

//    @ExceptionHandler(FeignException.FeignClientException.class)
//    public ResponseEntity<?> handleFeignClientException(FeignException.FeignClientException e) {
//        // FeignException에서 HTTP 상태 코드 추출
//        HttpStatus status = HttpStatus.valueOf(e.status());
//
//        try {
//            // B 서비스의 에러 응답을 파싱
//            String responseBody = e.contentUTF8();
//            ErrorResponse errorResponse = new ObjectMapper().readValue(responseBody, ErrorResponse.class);
//
//            return ResponseEntity
//                    .status(status)
//                    .body(errorResponse);
//        } catch (JsonProcessingException ex) {
//            // 파싱 실패시 FeignException의 메시지를 사용하여 새로운 ErrorResponse 생성
//            ErrorResponse fallbackResponse = new ErrorResponse(
//                    status,
//                    e.getMessage()
//            );
//
//            return ResponseEntity
//                    .status(status)
//                    .body(fallbackResponse);
//        }
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(error ->
                errors.put(error.getPropertyPath().toString(), error.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<?> handleDataAccessException(DataAccessException e) {
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(INTERNAL_SERVER_ERROR.name(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Error Message: {}", e.getMessage());
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(INTERNAL_SERVER_ERROR.name(), e.getMessage()));
    }

}
