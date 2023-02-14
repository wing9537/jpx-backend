package com.pandora.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseId {

    private final Integer val;

    public static BaseId valueOf(String text) {
        return new BaseId(Integer.valueOf(text));
    }

}
