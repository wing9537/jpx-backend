package com.pandora.jpx.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_chapter")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Chapter extends BasicInfo {

    @Column
    private Integer mangaId;

    @Column
    private float episode;

    @Column
    private String name;

    @Column
    private String desc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mangaId", insertable = false, updatable = false)
    private Manga manga;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_chapterImage", joinColumns = @JoinColumn(name = "chapterId"), inverseJoinColumns = @JoinColumn(name = "imageId"))
    private List<Image> imageList;
}
