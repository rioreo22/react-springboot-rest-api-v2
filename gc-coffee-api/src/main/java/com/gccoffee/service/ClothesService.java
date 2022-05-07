package com.gccoffee.service;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;

import java.util.List;

public interface ClothesService {

    List<Clothes> getClothesByCategory(Category category);

    List<Clothes> getAll();

    void saveClothes(Clothes clothes);

    void updateClothes(Clothes clothes);
}
