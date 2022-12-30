package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.ChapterImage;

public interface ChapterImageService {
    
    ChapterImage findById(Integer id);
    
    List<ChapterImage> findByChapterId(Integer chapterId);
    
    ChapterImage save(ChapterImage chapterImage);

}
