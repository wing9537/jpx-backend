package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Image;

public interface ImageService {

    Image findById(Integer id);
    
    List<Image> search(String name, String type);
    
    Image save(Image image);
    
}
