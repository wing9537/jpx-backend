package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.ChapterImage;

@Repository
public interface ChapterImageRepository extends BaseRepository<ChapterImage> {

    List<ChapterImage> findByChapterIdAndDeletedOrderBySeqAsc(Integer chapterId, String deleted);

    @Modifying
    @Query("update ChapterImage c set c.deleted = 'Y' where c.chapterId = ?1")
    void deleteByChapterId(Integer chapterId);

}
