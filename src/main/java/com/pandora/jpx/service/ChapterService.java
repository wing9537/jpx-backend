package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Chapter;

public interface ChapterService {

    public Chapter findById(Integer id);

    public List<Chapter> findByMangaId(Integer mangaId);

    public Chapter save(Chapter chapter);

    public void deleteById(Integer id);

}
