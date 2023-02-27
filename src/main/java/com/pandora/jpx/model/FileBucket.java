package com.pandora.jpx.model;

import lombok.Data;

@Data
public class FileBucket {

    private String name;

    private String source;

    private byte[] content;

}
