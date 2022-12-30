package com.pandora.jpx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pandora.jpx.entity.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {
    
    public List<Manga> findByName(String name);

}
