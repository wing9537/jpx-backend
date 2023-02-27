package com.pandora.jpx.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pandora.core.entity.BaseInfo;
import com.pandora.core.handler.BaseJsonEncodeHandler;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_chapter")
@EqualsAndHashCode(callSuper = true)
public class Chapter extends BaseInfo {

    @Column
    @JsonSerialize(using = BaseJsonEncodeHandler.class)
    private Integer mangaId;

    @Column
    private int episode;

    @Column
    private String name;

    @Column
    private String desc;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mangaId", insertable = false, updatable = false)
    private Manga manga;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<ChapterImage> imageList;

}
