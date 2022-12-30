package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Manga;

public interface MangaService {

    Manga findById(Integer id);
    
    List<Manga> search(String name, String author);
    
    Manga save(Manga manga);
    
}
