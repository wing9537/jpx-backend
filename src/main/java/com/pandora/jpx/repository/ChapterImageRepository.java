package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.ChapterImage;

@Repository
public interface ChapterImageRepository extends BaseRepository<ChapterImage> {

    List<ChapterImage> findByChapterIdAndDeletedOrderBySeqAsc(Integer chapterId, String deleted);

}
