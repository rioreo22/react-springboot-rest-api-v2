package com.gccoffee.controller;

import com.gccoffee.domain.clothes.Category;
import com.gccoffee.domain.clothes.Clothes;
import com.gccoffee.dto.request.ClothesRequest;
import com.gccoffee.service.ClothesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/clothes")
@RestController
public class ClothesRestController {

    private final ClothesService clothesService;
    @Value("${com.gccoffee.upload.path}")
    private String uploadPath;

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok().body(Category.values());
    }

    @GetMapping
    public ResponseEntity<?> getClothes() {
        return ResponseEntity.ok().body(clothesService.getAll());
    }

    @GetMapping("/image")
    public ResponseEntity getImage(String imageName) {
        log.info("getImage = " + imageName);
        ResponseEntity result = null;

        try {
            String pathname = uploadPath + File.separator + imageName;
            File file = new File(pathname);
            log.info("file: " + file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @PostMapping
    public void saveClothes(ClothesRequest clothesRequest) {

        log.info(clothesRequest.toString());

        MultipartFile clothesImage = clothesRequest.getImage();
        String imagePath = saveImage(clothesImage);
        log.info("imagePath = " + imagePath);
        Clothes clothes = clothesRequest.toEntity(imagePath);

        clothesService.saveClothes(clothes);
    }

    private String saveImage(MultipartFile uploadImage) {
        String imageName = uploadImage.getOriginalFilename();
        String folderPath = makeFolder();
        String imagePath = folderPath + File.separator + UUID.randomUUID() + "_" + imageName;
        String saveName = uploadPath + File.separator + imagePath;

        Path savePath = Paths.get(saveName);

        try {
            uploadImage.transferTo(savePath);
            log.info("saveClothes - image 저장 성공, savePath = {}", savePath);
        } catch (IOException e) {
            log.error("saveClothes - image 저장 실패, savePath = {}", savePath);
            throw new IllegalArgumentException();
        }
        return imagePath.replace(File.separatorChar, '/');
    }

    private String makeFolder() {
        String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).replace("/", File.separator);
        File uploadPathFolder = new File(uploadPath, localDate);

        if (!uploadPathFolder.exists()) uploadPathFolder.mkdirs();

        return localDate;
    }

}
