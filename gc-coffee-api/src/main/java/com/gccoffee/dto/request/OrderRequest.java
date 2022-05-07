package com.gccoffee.dto.request;

import com.gccoffee.domain.order.OrderItem;

import java.util.List;

public record OrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {
}
