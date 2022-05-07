package com.gccoffee.domain.clothes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
class JdbcClothesRepositoryTest {

    @Autowired
    private ClothesRepository clothesRepository;

    @Test
    void crud() {

        Clothes t_shirt = Clothes.builder()
                .id(UUID.randomUUID())
                .name("T-shirt")
                .price(39900)
                .imagePath("testPath")
                .category(Category.TOP)
                .description("test description")
                .createdAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .updatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .build();

        clothesRepository.insert(t_shirt);
        Clothes clothes = clothesRepository.findById(t_shirt.getId()).get();

        Clothes updated = Clothes.builder().
                id(t_shirt.getId())
                .name("updated T-shirt")
                .price(20000)
                .imagePath("testPath")
                .category(Category.BOTTOM)
                .description("updated description")
                .updatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
                .build();

        clothesRepository.update(updated);
        Clothes clothes1 = clothesRepository.findById(t_shirt.getId()).get();
        assertThat(clothes1.getName()).isEqualTo("updated T-shirt");
        assertThat(clothes1.getPrice()).isEqualTo(20000);
        assertThat(clothes1.getImagePath()).isEqualTo("testPath");
        assertThat(clothes1.getCategory()).isEqualTo(Category.BOTTOM);
        assertThat(clothes1.getDescription()).isEqualTo("updated description");
        assertThat(clothes1.getUpdatedAt()).isEqualTo(updated.getUpdatedAt());

        assertThat(clothes).isEqualTo(t_shirt);
        clothesRepository.deleteById(t_shirt.getId());
        Optional<Clothes> byId = clothesRepository.findById(t_shirt.getId());
        assertThat(byId).isEmpty();
    }


}