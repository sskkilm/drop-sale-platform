package com.example.product;

import com.example.product.application.port.ProductRepository;
import com.example.product.domain.EventProduct;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Profile("!test")
@Component
@RequiredArgsConstructor
public class TestProductDataInit {

    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        LocalDateTime now = LocalDateTime.now();

        EventProduct product = EventProduct.builder()
                .name("limited product")
                .price(new BigDecimal("20000"))
                .stockQuantity(10000)
                .openTime(now.minusMinutes(10))
                .build();
        EventProduct product2 = EventProduct.builder()
                .name("limited product2")
                .price(new BigDecimal("20000"))
                .stockQuantity(10000)
                .openTime(now.minusMinutes(10))
                .build();

        productRepository.save(product);
        productRepository.save(product2);
    }
}
