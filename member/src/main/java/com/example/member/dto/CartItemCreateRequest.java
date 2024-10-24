package com.example.member.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemCreateRequest(
        @NotNull Long productId,
        @Min(1) int quantity
) {

}
