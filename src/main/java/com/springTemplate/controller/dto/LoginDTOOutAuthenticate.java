package com.springTemplate.controller.dto;

public class LoginDTOOutAuthenticate {

    private String token;
    private String type;

    public LoginDTOOutAuthenticate(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
