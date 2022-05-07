package com.gccoffee.controller;

import com.gccoffee.domain.order.Email;
import com.gccoffee.dto.request.OrderRequest;
import com.gccoffee.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderRequest.orderItems().forEach(orderItem ->  log.info(orderItem.toString()));
        orderService.createOrder(
                new Email(orderRequest.email()),
                orderRequest.address(),
                orderRequest.postcode(),
                orderRequest.orderItems()
        );
    }

}