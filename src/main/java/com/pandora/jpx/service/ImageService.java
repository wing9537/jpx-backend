package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Image;

public interface ImageService {

    public Image findById(Integer id);

    public List<Image> search(String name, String type);

    public Image save(Image image);

}
