package com.example.order.dto;

import com.example.order.domain.OrderStatus;

public record OrderCancelResponse(
        Long orderId,
        Long memberId,
        OrderStatus status
) {
}
