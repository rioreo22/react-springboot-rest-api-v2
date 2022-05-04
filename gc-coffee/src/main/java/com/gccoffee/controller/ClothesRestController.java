package com.gccoffee.controller;

import com.gccoffee.dto.request.ClothesRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClothesRestController {

    @Value("${com.gccoffee.upload.path}")
    private String uploadPath;

    @PostMapping("/api/v1/clothes")
    public void saveClothes(ClothesRequest clothesRequest) {

        MultipartFile clothesImage = clothesRequest.getImage();
        String imagePath = saveImage(clothesImage);


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
