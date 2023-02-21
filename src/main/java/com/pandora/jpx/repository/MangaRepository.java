package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pandora.core.repository.BaseRepository;
import com.pandora.jpx.entity.Manga;

@Repository
public interface MangaRepository extends BaseRepository<Manga> {

    List<Manga> findByName(String name);

}
