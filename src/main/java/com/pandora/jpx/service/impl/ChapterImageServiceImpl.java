package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.ChapterImage;
import com.pandora.jpx.repository.ChapterImageRepository;
import com.pandora.jpx.service.ChapterImageService;

@Service
public class ChapterImageServiceImpl implements ChapterImageService {

    @Autowired
    private ChapterImageRepository chapterImageRepository;

    @Override
    @Transactional
    public ChapterImage findById(Integer id) {
        return chapterImageRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<ChapterImage> findByChapterId(Integer chapterId) {
        return chapterImageRepository.findByChapterIdAndDeletedOrderBySeqAsc(chapterId, "N");
    }

    @Override
    @Transactional
    public ChapterImage save(ChapterImage chapterImage) {
        return chapterImageRepository.save(chapterImage);
    }

    @Override
    @Transactional
    public void deleteByChapterId(Integer chapterId) {
        chapterImageRepository.deleteByChapterId(chapterId);
    }

}
