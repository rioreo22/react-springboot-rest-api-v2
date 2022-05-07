package com.gccoffee.service;

import com.gccoffee.domain.order.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems) {
        Order order = Order.builder()
                .id(UUID.randomUUID())
                .email(email)
                .address(address)
                .postCode(postcode)
                .orderStatus(OrderStatus.ACCEPTED)
                .orderItems(orderItems)
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .updatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .build();

        orderRepository.insert(order);

        return order;
    }
}
