package com.pandora.jpx.service;

import java.util.List;

import com.pandora.jpx.entity.Manga;
import com.pandora.jpx.form.MangaSearchForm;

public interface MangaService {

    public Manga findById(Integer id);

    public List<Manga> search(MangaSearchForm form);

    public Manga save(Manga manga);

    public void deleteById(Integer id);

}
