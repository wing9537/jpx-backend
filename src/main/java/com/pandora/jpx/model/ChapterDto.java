package com.pandora.jpx.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pandora.core.handler.BaseJsonEncodeHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChapterDto {

    @JsonSerialize(using = BaseJsonEncodeHandler.class)
    private Integer id;

    private int episode;

    private String name;

}
