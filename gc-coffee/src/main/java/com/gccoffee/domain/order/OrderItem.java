package com.gccoffee.domain.order;

import com.gccoffee.domain.clothes.Category;

import java.util.UUID;

public record OrderItem(UUID orderId, UUID clothesId, Category category, long price, long quantity) {
}
