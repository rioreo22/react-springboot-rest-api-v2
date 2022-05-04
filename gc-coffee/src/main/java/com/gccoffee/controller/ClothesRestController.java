package com.gccoffee.controller;

import com.gccoffee.dto.request.ClothesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ClothesRestController {

    @PostMapping("/api/v1/clothes")
    public void saveClothes(ClothesRequest clothesRequest) {
        log.info(clothesRequest.getImage().getOriginalFilename());
        log.info(clothesRequest.getName());
        log.info(clothesRequest.getCategory().toString());
    }

}
