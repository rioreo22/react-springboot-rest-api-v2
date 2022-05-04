package com.gccoffee.dto.request;

import com.gccoffee.domain.clothes.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@Getter
@Setter
public class ClothesRequest {

    MultipartFile image;
    String name;
    Category category;
}
