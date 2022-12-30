package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pandora.jpx.entity.ChapterImage;
import com.pandora.jpx.repository.ChapterImageRepository;
import com.pandora.jpx.service.ChapterImageService;

public class ChapterImageServiceImpl implements ChapterImageService {

    @Autowired
    private ChapterImageRepository chapterImageRepository;

    @Override
    public ChapterImage findById(Integer id) {
        return chapterImageRepository.findById(id).get();
    }

    @Override
    public List<ChapterImage> findByChapterId(Integer chapterId) {
        return chapterImageRepository.findByChapterIdOrderBySeqAsc(chapterId);
    }

    @Override
    public ChapterImage save(ChapterImage chapterImage) {
        return chapterImageRepository.save(chapterImage);
    }
    
}