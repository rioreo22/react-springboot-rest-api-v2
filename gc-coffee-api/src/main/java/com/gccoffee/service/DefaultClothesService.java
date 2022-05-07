package com.gccoffee.service;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;
import com.gccoffee.domain.clothes.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DefaultClothesService implements ClothesService {

    private final ClothesRepository clothesRepository;

    @Override
    public List<Clothes> getClothesByCategory(Category category) {
        return clothesRepository.findByCategory(category);
    }

    @Override
    public List<Clothes> getAll() {
        return clothesRepository.findAll();
    }
    @Override
    public void saveClothes(Clothes clothes){
        clothesRepository.insert(clothes);
    }


    @Override
    public void updateClothes(Clothes clothes) {
        clothesRepository.update(clothes);
    }
}
