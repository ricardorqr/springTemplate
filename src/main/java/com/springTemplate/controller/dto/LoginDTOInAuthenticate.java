package com.springTemplate.controller.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTOInAuthenticate {

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 200)
    private String email;
    @NotNull
    @NotEmpty
    @Length(min = 5, max = 200)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
