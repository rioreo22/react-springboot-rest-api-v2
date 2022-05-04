package com.gccoffee.controller;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;
import com.gccoffee.dto.request.ClothesRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/clothes")
@RestController
public class ClothesRestController {

    @Value("${com.gccoffee.upload.path}")
    private String uploadPath;

    @GetMapping("categories")
    public ResponseEntity<?> getCategorys(){
        return ResponseEntity.ok().body(Category.values());
    }

    @GetMapping
    public ResponseEntity<?> getClothes() {
        Clothes clothes = Clothes.builder().id(UUID.randomUUID()).name("T-shirt").price(1234).imagePath("adsfadf").description("deadlfkjasl").createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
        return ResponseEntity.ok().body(List.of(clothes,clothes,clothes,clothes,clothes,clothes));
    }


    @PostMapping
    public void saveClothes(ClothesRequest clothesRequest, HttpServletResponse response) {

        log.info(clothesRequest.toString());

        MultipartFile clothesImage = clothesRequest.getImage();
        String imagePath = saveImage(clothesImage);
        Clothes clothes = clothesRequest.toEntity(imagePath);

    }

    private String saveImage(MultipartFile uploadImage) {
        String imageName = uploadImage.getOriginalFilename();
        String folderPath = makeFolder();
        String saveName = uploadPath + '/' + folderPath + '/' + UUID.randomUUID() + "_" + imageName;
        Path savePath = Paths.get(saveName);
        try {
            uploadImage.transferTo(savePath);
            log.info("saveClothes - image 저장 성공, savePath = {}", savePath);
        } catch (IOException e) {
            log.error("saveClothes - image 저장 실패, savePath = {}", savePath);
            throw new IllegalArgumentException();
        }
        return saveName;
    }

    private String makeFolder() {
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        File uploadPathFolder = new File(uploadPath, localDate);

        if (!uploadPathFolder.exists()) uploadPathFolder.mkdirs();

        return localDate;
    }

}
