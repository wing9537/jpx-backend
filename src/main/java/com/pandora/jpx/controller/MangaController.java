package com.pandora.jpx.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.core.controller.BaseController;
import com.pandora.core.model.BaseResponse;
import com.pandora.jpx.form.MangaForm;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/manga")
public class MangaController extends BaseController {

    @PostMapping("/new")
    public BaseResponse createManga(@Valid @RequestBody MangaForm form) {
        return BaseResponse.ok;
    }

    @GetMapping("/{id}")
    public BaseResponse readManga(@PathVariable String id) {
        return BaseResponse.ok;
    }

    @PutMapping("/{id}")
    public BaseResponse updateManga(@PathVariable String id, @Valid @RequestBody MangaForm form) {
        return BaseResponse.ok;
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteManga(@PathVariable String id) {
        return BaseResponse.ok;
    }

    @GetMapping("/search")
    public BaseResponse searchManga(@Valid @RequestParam MangaForm form) {
        return BaseResponse.ok;
    }

    @PatchMapping("/{id}/chapter/{ep}/fetch")
    public BaseResponse fetchChapter(@PathVariable String id, @PathVariable float ep) {
        return BaseResponse.ok;
    }

    @GetMapping("/chapter/{id}")
    public BaseResponse readChapter(@PathVariable String id) {
        return BaseResponse.ok;
    }

    @DeleteMapping("/chapter/{id}")
    public BaseResponse deleteChapter(@PathVariable String id) {
        return BaseResponse.ok;
    }

}
