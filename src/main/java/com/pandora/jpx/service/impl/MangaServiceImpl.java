package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.Manga;
import com.pandora.jpx.repository.MangaRepository;
import com.pandora.jpx.service.MangaService;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Override
    @Transactional
    public Manga findById(Integer id) {
        return mangaRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Manga> search(String name, String author) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public Manga save(Manga manga) {
        return mangaRepository.save(manga);
    }
    
}
