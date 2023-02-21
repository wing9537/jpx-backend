package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.Chapter;

@Repository
public interface ChapterRepository extends BaseRepository<Chapter> {

    List<Chapter> findByMangaIdAndDeletedOrderByEpisodeDesc(Integer mangaId, String deleted);

}
