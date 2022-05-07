package com.gccoffee.domain.clothes;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@EqualsAndHashCode
@Builder
@Getter
public class Clothes {
    private UUID id;
    private String name;
    private long price;
    private String imagePath;
    private String description;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
