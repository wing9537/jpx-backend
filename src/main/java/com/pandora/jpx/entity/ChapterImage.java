package com.pandora.jpx.entity;

import com.pandora.core.entity.BaseInfo;

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

    @Column
    private Integer mangaId;

    @Column
    private Integer chapterId;

    @Column
    private Integer imageId;

    @Column
    private int seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangaId", insertable = false, updatable = false)
    private Manga manga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId", insertable = false, updatable = false)
    private Chapter chapter;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imageId", insertable = false, updatable = false)
    private Image image;

}
