package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.Chapter;
import com.pandora.jpx.model.ChapterDto;

@Repository
public interface ChapterRepository extends BaseRepository<Chapter> {

    List<ChapterDto> findByMangaIdAndDeletedOrderByEpisodeDesc(Integer mangaId, String deleted);

    Chapter findByMangaIdAndEpisodeAndDeleted(Integer mangaId, Integer episode, String deleted);

}
