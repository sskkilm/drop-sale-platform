package com.example.common.domain;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {

    public static Money of(String amount) {
        return new Money(new BigDecimal(amount));
    }

    public Money multiply(int quantity) {
        return new Money(this.amount.multiply(
                new BigDecimal(String.valueOf(quantity))
        ));
    }
}
