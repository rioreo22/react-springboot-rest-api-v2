package com.gccoffee.domain.order;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Order {
    private UUID id;
    private Email email;
}
