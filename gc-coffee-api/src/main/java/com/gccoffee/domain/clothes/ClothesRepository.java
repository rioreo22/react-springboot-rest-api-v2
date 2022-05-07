package com.gccoffee.domain.clothes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClothesRepository {
    void insert(Clothes clothes);

    void insertAll(List<Clothes> clothesList);

    List<Clothes> findByName(String name);

    List<Clothes> findByCategory(Category category);

    Optional<Clothes> findById(UUID id);

    void update(Clothes clothes);

    void deleteByName(String name);

    void deleteById(UUID id);

    List<Clothes> findAll();
}
