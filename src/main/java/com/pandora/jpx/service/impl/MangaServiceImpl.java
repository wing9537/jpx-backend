package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.pandora.core.handler.BaseSqlBuilder;
import com.pandora.jpx.entity.Manga;
import com.pandora.jpx.form.MangaSearchForm;
import com.pandora.jpx.repository.MangaRepository;
import com.pandora.jpx.service.MangaService;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaRepository mangaRepository;

    public MangaServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    @Transactional
    public Manga findById(Integer id) {
        return mangaRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Manga> search(MangaSearchForm form) {
        return mangaRepository.findAll((root, query, builder) -> {
            BaseSqlBuilder<Manga> sqlBuilder = new BaseSqlBuilder<>(root, builder);
            if (StringUtils.hasText(form.getName())) {
                sqlBuilder.like("name", form.getName());
            }
            if (StringUtils.hasText(form.getAuthor())) {
                sqlBuilder.like("author", form.getAuthor());
            }
            return sqlBuilder.build();
        });
    }

    @Override
    @Transactional
    public Manga save(Manga manga) {
        return mangaRepository.save(manga);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        mangaRepository.deleteById(id);
    }

}
