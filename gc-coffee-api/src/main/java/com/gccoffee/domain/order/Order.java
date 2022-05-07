package com.gccoffee.domain.order;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class Order {
    private UUID id;
    private Email email;
    private String address;
    private String postCode;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
