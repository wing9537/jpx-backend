package com.pandora.jpx.service;

import com.pandora.jpx.entity.Image;

public interface ImageService {

    public Image findById(Integer id);

    public Image save(Image image);

}
