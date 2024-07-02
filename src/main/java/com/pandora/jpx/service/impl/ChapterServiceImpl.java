package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.Chapter;
import com.pandora.jpx.model.ChapterDto;
import com.pandora.jpx.repository.ChapterRepository;
import com.pandora.jpx.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    @Transactional
    public Chapter findById(Integer id) {
        return chapterRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<ChapterDto> findByMangaId(Integer mangaId) {
        return chapterRepository.findByMangaIdAndDeletedOrderByEpisodeDesc(mangaId, "N");
    }

    @Override
    @Transactional
    public Chapter findByMangaIdAndEpisode(Integer mangaId, Integer episode) {
        return chapterRepository.findByMangaIdAndEpisodeAndDeleted(mangaId, episode, "N");
    }

    @Override
    @Transactional
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        chapterRepository.deleteById(id);
    }

}
