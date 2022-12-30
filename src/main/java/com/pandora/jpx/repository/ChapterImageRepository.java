package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pandora.jpx.entity.ChapterImage;

@Repository
public interface ChapterImageRepository extends JpaRepository<ChapterImage, Integer> {
    
    public List<ChapterImage> findByChapterIdOrderBySeqAsc(Integer chapterId);

}
