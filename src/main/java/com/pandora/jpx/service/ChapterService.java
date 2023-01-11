package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Chapter;

public interface ChapterService {

    public Chapter findById(Integer id);

    public List<Chapter> search(Integer mangaId, float episode, String name);

    public Chapter save(Chapter chapter);

}
