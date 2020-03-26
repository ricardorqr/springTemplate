package com.springTemplate.controller;

import com.springTemplate.config.security.TokenService;
import com.springTemplate.controller.dto.LoginDTOInAuthenticate;
import com.springTemplate.controller.dto.LoginDTOOutAuthenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginDTOOutAuthenticate> authenticate(@RequestBody @Valid LoginDTOInAuthenticate login) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = login.getUsernamePasswordAuthenticationToken();
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            String token = tokenService.newToken(authentication);
            return ResponseEntity.ok(new LoginDTOOutAuthenticate(token, "Bearer"));
        }catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
