package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.Image;
import com.pandora.jpx.repository.ImageRepository;
import com.pandora.jpx.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional
    public Image findById(Integer id) {
        return imageRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Image> search(String name, String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }
    
}
