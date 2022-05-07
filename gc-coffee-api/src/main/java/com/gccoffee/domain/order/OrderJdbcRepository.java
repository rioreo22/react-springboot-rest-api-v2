package com.gccoffee.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void insert(Order order) {
        jdbcTemplate.update("INSERT INTO orders (order_id, email, address, postcode, order_status, created_at, updated_at) " +
                        "values (UUID_TO_BIN( ?), ?,?,?,?,?,?)",
                order.getId().toString().getBytes(),
                order.getEmail().getAddress(),
                order.getAddress(),
                order.getPostCode(),
                order.getOrderStatus().toString(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );

        order.getOrderItems().forEach(item -> {
            jdbcTemplate.update("INSERT INTO order_items(order_id, clothes_id, category, price, quantity, createed_at, updated_at) " +
                            "VALUES (UUID_TO_BIN(?), UUID_TO_BIN(?), ?, ?, ?, ?, ?)",
                    order.getId().toString().getBytes(),
                    item.clothesId().toString().getBytes(),
                    item.category(),
                    item.price(),
                    item.quantity(),
                    order.getCreatedAt(),
                    order.getUpdatedAt()
            );
        });
    }
}
