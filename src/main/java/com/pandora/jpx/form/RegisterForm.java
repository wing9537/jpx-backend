package com.pandora.jpx.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterForm {

    @NotBlank
    @Length(min = 1, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String username;

    @NotNull
    @Length(min = 8, max = 20)
    private String password;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @Email
    private String email;

    @Pattern(regexp = "^(?:[3-9][0-9]{7}|)$")
    private String mobile;

}
