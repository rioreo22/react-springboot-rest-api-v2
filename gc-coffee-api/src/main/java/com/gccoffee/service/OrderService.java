package com.gccoffee.service;

import com.gccoffee.domain.order.Email;
import com.gccoffee.domain.order.Order;
import com.gccoffee.domain.order.OrderItem;

import java.util.List;

public interface OrderService {
    Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems);
}
