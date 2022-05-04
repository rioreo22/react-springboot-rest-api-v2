package com.gccoffee.controller;

import com.gccoffee.dto.request.ClothesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClothesRestController {

    @PostMapping("/api/v1/clothes")
    public void saveClothes(@RequestBody ClothesRequest clothesRequest) {
        log.info(clothesRequest.getImage().getName());
    }

}
