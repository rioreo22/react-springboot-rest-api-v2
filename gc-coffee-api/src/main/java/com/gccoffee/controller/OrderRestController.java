package com.gccoffee.controller;

import com.gccoffee.dto.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        log.info(orderRequest.email());
    }

    @GetMapping
    public void orderList() {
    }
}