package com.example.order.application.scheduler;

import com.example.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReturnProcessingScheduler {

    private final OrderService orderService;

    @Scheduled(cron = "0 0 9 * * *")
    public void returnProcessing() {
        orderService.returnProcessing();
    }
}
