package com.gccoffee.service;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;

import java.util.List;

public interface ClothesService {

    List<Clothes> getClothesByCategory();

    List<Clothes> getAll();

    Clothes createClothes(String name, Category category, long price);

    Clothes createClothes(String name, Category category, long price, String description);

    void saveClothes(Clothes clothes);
}
