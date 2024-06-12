package com.pandora.jpx.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pandora.core.handler.BaseJsonDecodeHandler;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MangaForm {

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    private String desc;

    @NotBlank
    private String link;

    @JsonDeserialize(using = BaseJsonDecodeHandler.class)
    private Integer coverPage;

    @Min(1)
    private int latestChapter;

}
