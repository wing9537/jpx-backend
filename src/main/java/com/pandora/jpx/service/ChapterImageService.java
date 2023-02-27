package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.ChapterImage;

public interface ChapterImageService {

    public ChapterImage findById(Integer id);

    public List<ChapterImage> findByChapterId(Integer chapterId);

    public ChapterImage save(ChapterImage chapterImage);

    public void deleteByChapterId(Integer chapterId);

}
