package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Manga;

public interface MangaService {

    public Manga findById(Integer id);

    public List<Manga> search(String name, String author);

    public Manga save(Manga manga);

}
