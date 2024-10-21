package com.example.order.infrastructure.order.product;

import com.example.order.application.repository.OrderProductRepository;
import com.example.order.domain.OrderProduct;
import com.example.order.infrastructure.entity.OrderProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderProductRepositoryImpl implements OrderProductRepository {

    private final OrderProductJpaRepository orderProductJpaRepository;

    @Override
    public void saveAll(List<OrderProduct> orderProducts) {
        orderProductJpaRepository.saveAll(
                orderProducts.stream().map(OrderProductEntity::from).toList()
        );
    }

}