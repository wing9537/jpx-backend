package com.pandora.core.model;

import lombok.Data;

@Data
public class BaseId {

    private Integer val;

    private String original;

    public BaseId(String text) {
        this.val = Integer.valueOf(text);
        this.original = text;
    }

}
