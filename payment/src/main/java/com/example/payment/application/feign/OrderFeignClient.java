package com.example.payment.application.feign;


import com.example.payment.dto.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway", path = "/orders", contextId = "orderClient")
public interface OrderFeignClient {

    @GetMapping("/internal/{memberId}/validate")
    boolean validateOrderInfo(@PathVariable Long memberId, OrderInfo orderInfo);

}
