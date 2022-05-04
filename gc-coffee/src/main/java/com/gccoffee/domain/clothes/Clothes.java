package com.gccoffee.domain.clothes;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class Clothes {
    private UUID id;
    private String name;
    private long price;
    private String description;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
