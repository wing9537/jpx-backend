package com.pandora.jpx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pandora.jpx.entity.Chapter;
import com.pandora.jpx.repository.ChapterRepository;
import com.pandora.jpx.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    @Transactional
    public Chapter findById(Integer id) {
        return chapterRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Chapter> search(Integer mangaId, float episode, String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }
    
}
