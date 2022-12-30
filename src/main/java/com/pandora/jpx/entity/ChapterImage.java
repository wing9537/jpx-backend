package com.pandora.jpx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_chapterImage")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChapterImage extends BasicInfo {

    @Column
    private Integer mangaId;

    @Column
    private Integer chapterId;

    @Column
    private Integer imageId;

    @Column
    private int seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangaId")
    private Manga manga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId")
    private Chapter chapter;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imageId")
    private Image image;
}
