package com.pandora.jpx.entity;

import java.sql.Timestamp;
import java.util.List;

import com.pandora.core.entity.BaseInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_manga")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
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
    private Integer coverPage;

    @Column
    private float latestChapter;

    @Column
    private Timestamp lastUpdateTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coverPage", insertable = false, updatable = false)
    private Image coverImage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manga")
    private List<Chapter> chapterList;

}
