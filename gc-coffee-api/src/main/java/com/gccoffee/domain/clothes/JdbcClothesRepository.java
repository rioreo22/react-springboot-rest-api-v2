package com.gccoffee.domain.clothes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.gccoffee.util.JdbcUtils.*;

@Slf4j
@RequiredArgsConstructor
@Repository
public class JdbcClothesRepository implements ClothesRepository {

    private static final RowMapper<Clothes> clothesRowMapper = (resultSet, i) -> {
        UUID id = UUIDBytesToUUID(resultSet.getBytes("clothes_id"));
        String name = resultSet.getString("clothes_name");
        Category category = Category.valueOf(resultSet.getString("category"));
        String imagePath = resultSet.getString("image_path");
        long price = resultSet.getLong("price");
        String description = resultSet.getString("description");
        LocalDateTime createdAt = toLocalDateTime(resultSet.getTimestamp("created_at"));
        LocalDateTime updatedAt = toLocalDateTime(resultSet.getTimestamp("updated_at"));
        return Clothes.builder().id(id).name(name).price(price).imagePath(imagePath).description(description).createdAt(createdAt).updatedAt(updatedAt).category(category).build();
    };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Clothes clothes) {
        jdbcTemplate.update("INSERT INTO clothes (clothes_id, clothes_name, category, price, description, created_at, updated_at, image_path) " +
                        "VALUES (UUID_TO_BIN(?), ?, ?, ?, ?, ?, ?,?)",
                clothes.getId().toString().getBytes(),
                clothes.getName(),
                clothes.getCategory().toString(),
                clothes.getPrice(),
                clothes.getDescription(),
                clothes.getCreatedAt(),
                clothes.getUpdatedAt(),
                clothes.getImagePath()
        );
    }

    @Override
    public void insertAll(List<Clothes> clothesList) {
        clothesList.forEach(this::insert);
    }

    @Override
    public List<Clothes> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM clothes WHERE clothes_name = ?",
                clothesRowMapper,
                name);
    }

    @Override
    public List<Clothes> findByCategory(Category category) {
        return jdbcTemplate.query("SELECT * FROM clothes WHERE category = ?",
                clothesRowMapper,
                category.toString());
    }

    @Override
    public Optional<Clothes> findById(UUID id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM clothes WHERE clothes_id = UUID_TO_BIN(?)",
                    clothesRowMapper,
                    id.toString().getBytes()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void update(Clothes clothes) {
        jdbcTemplate.update("UPDATE clothes SET clothes_name = ?, category = ?, price = ?, description = ?,image_path =?, updated_at =? WHERE clothes_id = UUID_TO_BIN(?)",
                clothes.getName(),
                clothes.getCategory().toString(),
                clothes.getPrice(),
                clothes.getDescription(),
                clothes.getImagePath(),
                clothes.getUpdatedAt(),
                clothes.getId().toString().getBytes()
        );
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM clothes WHERE clothes_name = ?", name);
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update("DELETE FROM clothes WHERE clothes_id = UUID_TO_BIN(?)", id.toString().getBytes());
    }

    @Override
    public List<Clothes> findAll() {
        return jdbcTemplate.query("SELECT * FROM clothes", clothesRowMapper);
    }
}
