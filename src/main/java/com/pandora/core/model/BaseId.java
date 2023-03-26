package com.pandora.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pandora.core.handler.BaseJsonEncodeHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseId {

    @JsonProperty("id")
    @JsonSerialize(using = BaseJsonEncodeHandler.class)
    private final Integer val;

    public static BaseId valueOf(String text) {
        return new BaseId(Integer.valueOf(text));
    }

}
