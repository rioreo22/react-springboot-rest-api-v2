package com.gccoffee.controller;

import com.gccoffee.domain.order.Email;
import com.gccoffee.domain.order.Order;
import com.gccoffee.dto.request.OrderRequest;
import com.gccoffee.service.OrderService;
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

//    @PostMapping("/api/v1/orders")
//    public Order createOrder(@RequestBody OrderRequest orderRequest) {
//        log.info(orderRequest.email());
//
//        return orderService.createOrder(
//
//                new Email(orderRequest.email()),
//                orderRequest.address(),
//                orderRequest.postcode(),
//                orderRequest.orderItems()
//        );
//    }

}