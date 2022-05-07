package com.gccoffee.service;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;

import java.util.List;

public class DefaultClothesService implements ClothesService{
    @Override
    public List<Clothes> getClothesByCategory() {
        return null;
    }

    @Override
    public List<Clothes> getAll() {
        return null;
    }

    @Override
    public Clothes createClothes(String name, Category category, long price) {
        return null;
    }

    @Override
    public Clothes createClothes(String name, Category category, long price, String description) {
        return null;
    }

    @Override
    public void saveClothes(Clothes clothes) {

    }
}
