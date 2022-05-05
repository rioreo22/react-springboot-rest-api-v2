package com.gccoffee.controller;

import com.gccoffee.dto.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderRestController {

//    private final OrderService orderService;
//
//    public OrderRestController(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @PostMapping("/api/v1/orders")
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        log.info(orderRequest.email());
    }

}