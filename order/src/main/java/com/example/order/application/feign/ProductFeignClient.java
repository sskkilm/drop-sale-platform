package com.example.order.application.feign;

import com.example.order.dto.ProductPurchaseRequest;
import com.example.order.dto.ProductPurchaseResponse;
import com.example.order.dto.ProductRestoreStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "api-gateway", path = "/products")
public interface ProductFeignClient {

    @PostMapping("/internal/purchase")
    List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> productPurchaseRequests);

    @PostMapping("/internal/restore-stock")
    void restoreStock(List<ProductRestoreStockRequest> productRestoreStockRequests);

    @GetMapping("/disability-situation/case1")
    ResponseEntity<String> case1();

    @GetMapping("/disability-situation/case2")
    ResponseEntity<String> case2();

    @GetMapping("/disability-situation/case3")
    ResponseEntity<String> case3();
}
