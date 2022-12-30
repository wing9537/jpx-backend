package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Chapter;

public interface ChapterService {

    Chapter findById(Integer id);
    
    List<Chapter> search(Integer mangaId, float episode, String name);
    
    Chapter save(Chapter chapter);

}
