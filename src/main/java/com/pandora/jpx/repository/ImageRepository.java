package com.pandora.jpx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pandora.jpx.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    
}
