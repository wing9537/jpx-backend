package com.pandora.jpx.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pandora.core.entity.BaseInfo;
import com.pandora.core.handler.BaseJsonEncodeHandler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_manga")
@EqualsAndHashCode(callSuper = true)
public class Manga extends BaseInfo {

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String desc;

    @Column
    private String link;

    @Column
    @JsonSerialize(using = BaseJsonEncodeHandler.class)
    private Integer coverPage;

    @Column
    private int latestChapter;

    @Column
    private Timestamp lastUpdateTime;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coverPage", insertable = false, updatable = false)
    private Image coverImage;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manga")
    private List<Chapter> chapterList;

}
