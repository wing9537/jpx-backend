package com.pandora.jpx.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
