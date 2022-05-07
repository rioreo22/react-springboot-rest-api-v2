package com.gccoffee.dto.request;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class ClothesRequest {
    @NotNull
    private MultipartFile image;
    @NotNull
    private String name;
    @NotNull
    private long price;
    private String description;
    @NotNull
    private Category category;


    public Clothes toEntity(String imagePath) {
        return Clothes.builder()
                .id(UUID.randomUUID())
                .name(name)
                .price(price)
                .imagePath(imagePath)
                .description(description)
                .category(category)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
