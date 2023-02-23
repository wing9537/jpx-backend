package com.pandora.jpx.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.core.controller.BaseController;
import com.pandora.core.model.BaseId;
import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.entity.Chapter;
import com.pandora.jpx.entity.Manga;
import com.pandora.jpx.form.MangaForm;
import com.pandora.jpx.form.MangaSearchForm;
import com.pandora.jpx.service.ChapterService;
import com.pandora.jpx.service.MangaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manga")
public class MangaController extends BaseController {

    @Autowired
    private MangaService mangaService;

    @Autowired
    private ChapterService chapterService;

    @PostMapping("/new")
    public BaseResponse createManga(@Valid @RequestBody MangaForm form) {
        Manga manga = new Manga();
        BeanUtils.copyProperties(form, manga);
        mangaService.save(manga);
        return BaseResponse.ok;
    }

    @GetMapping("/{id}")
    public BaseResponse readManga(@PathVariable BaseId id) {
        Manga manga = mangaService.findById(id.getVal());
        return BaseResponse.accept(manga);
    }

    @PutMapping("/{id}")
    public BaseResponse updateManga(@PathVariable BaseId id, @Valid @RequestBody MangaForm form) {
        Manga manga = mangaService.findById(id.getVal());
        BeanUtils.copyProperties(form, manga);
        mangaService.save(manga);
        return BaseResponse.ok;
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteManga(@PathVariable BaseId id) {
        mangaService.deleteById(id.getVal());
        return BaseResponse.ok;
    }

    @GetMapping("/search")
    public BaseResponse searchManga(@ParameterObject MangaSearchForm form) {
        List<Manga> mangaList = mangaService.search(form);
        return BaseResponse.accept(mangaList);
    }

    @PatchMapping("/{id}/chapter/{ep}/fetch")
    public BaseResponse fetchChapter(@PathVariable BaseId id, @PathVariable float ep) {
        return BaseResponse.ok;
    }

    @GetMapping("/chapter/{id}")
    public BaseResponse readChapter(@PathVariable BaseId id) {
        Chapter chapter = chapterService.findById(id.getVal());
        return BaseResponse.accept(chapter);
    }

    @DeleteMapping("/chapter/{id}")
    public BaseResponse deleteChapter(@PathVariable BaseId id) {
        chapterService.deleteById(id.getVal());
        return BaseResponse.ok;
    }

}
