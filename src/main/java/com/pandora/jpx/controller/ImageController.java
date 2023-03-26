package com.pandora.jpx.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pandora.core.controller.BaseController;
import com.pandora.core.model.BaseId;
import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.entity.Image;
import com.pandora.jpx.entity.Image.FileType;
import com.pandora.jpx.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController extends BaseController {

    @Autowired
    private ImageService imageService;

    private static final List<String> ALLOWED_IMAGE_CONTENT_TYPES = Arrays.asList(
            "image/jpeg", "image/png", "image/gif", "image/bmp");

    @PostMapping(path = "/{type}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseResponse createImage(@PathVariable FileType type, @RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty() || !ALLOWED_IMAGE_CONTENT_TYPES.contains(file.getContentType())) {
            return BaseResponse.badRequest;
        }
        // save
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setFileType(type);
        image.setMimeType(file.getContentType());
        image.setContent(file.getBytes());

        image = imageService.save(image);
        return BaseResponse.accept(new BaseId(image.getId()));
    }

    @GetMapping("/{id}")
    public BaseResponse readImage(@PathVariable BaseId id) {
        Image image = imageService.findById(id.getVal());
        return BaseResponse.accept(image);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteImage(@PathVariable BaseId id) {
        imageService.deleteById(id.getVal());
        return BaseResponse.ok;
    }

}
