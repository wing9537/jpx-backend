package com.pandora.jpx.entity;

import com.pandora.core.entity.BaseInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_image")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Image extends BaseInfo {

    public enum FileType {
        Manga, Cover, Icon, Others
    };

    @Column
    private String fileName;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Column
    private String mimeType;

    @Column
    private byte[] content;

}
