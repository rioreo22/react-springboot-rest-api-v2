package com.gccoffee.domain.clothes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Repository
public class JdbcClothesRepository implements ClothesRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Clothes clothes) {

    }

    @Override
    public void insertAll(List<Clothes> clothesList) {

    }

    @Override
    public List<Clothes> findByName(String name) {
        return null;
    }

    @Override
    public List<Clothes> findByType(Category clothesType) {
        return null;
    }

    @Override
    public Optional<Clothes> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void update(Clothes clothes) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public List<Clothes> findAll() {
        return null;
    }
}
