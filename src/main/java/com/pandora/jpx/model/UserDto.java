package com.pandora.jpx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String username;

    private String password;

    private String name;

    private String email;

    private String mobile;

}
