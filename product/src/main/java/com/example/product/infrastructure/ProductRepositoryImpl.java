package com.example.product.infrastructure;

import com.example.product.application.ProductRepository;
import com.example.product.domain.Product;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.infrastructure.entity.ProductEntity;
import com.example.product.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductQueryRepository productQueryRepository;
    private final ProductMapper productMapper;

    @Override
    public Product findById(Long id) {
        return productJpaRepository.findById(id).map(ProductEntity::toModel)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(productMapper.toEntity(product)).toModel();
    }

    @Override
    public List<Product> findAllSellableProduct(LocalDateTime now) {
        return productQueryRepository.findAllSellableProduct(now)
                .stream().map(ProductEntity::toModel).toList();
    }

}
