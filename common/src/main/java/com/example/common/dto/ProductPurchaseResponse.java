package com.example.common.dto;

import com.example.common.domain.Money;

public record ProductPurchaseResponse(
        Long productId, String productName, int quantity, Money purchaseAmount
) {
}
