package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Chapter;
import com.pandora.jpx.model.ChapterDto;

public interface ChapterService {

    public Chapter findById(Integer id);

    public List<ChapterDto> findByMangaId(Integer mangaId);

    public Chapter findByMangaIdAndEpisode(Integer mangaId, Integer episode);

    public Chapter save(Chapter chapter);

    public void deleteById(Integer id);

}
