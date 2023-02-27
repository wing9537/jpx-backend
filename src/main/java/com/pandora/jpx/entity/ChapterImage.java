package com.pandora.jpx.entity;

import com.pandora.core.entity.BaseInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_chapterImage")
@EqualsAndHashCode(callSuper = true)
public class ChapterImage extends BaseInfo {

    @Column(insertable = false, updatable = false)
    private Integer mangaId;

    @Column(insertable = false, updatable = false)
    private Integer chapterId;

    @Column(insertable = false, updatable = false)
    private Integer imageId;

    @Column
    private int seq;

    @Column
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangaId", nullable = false)
    private Manga manga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId", nullable = false)
    private Chapter chapter;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId", nullable = false)
    private Image image;

}
