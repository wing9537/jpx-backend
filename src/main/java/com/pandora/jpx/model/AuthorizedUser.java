package com.pandora.jpx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizedUser {

    private String name;

    private String token;

}
