package com.example.product.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class HoldStock {
    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;

    public static HoldStock create(Long orderId, Long productId, int quantity) {
        return HoldStock.builder()
                .orderId(orderId)
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}