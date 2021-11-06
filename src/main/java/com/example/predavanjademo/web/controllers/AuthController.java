package com.example.predavanjademo.web.controllers;


import com.example.predavanjademo.security.jwt.JwtToken;
import com.example.predavanjademo.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity<JwtToken> login(@RequestBody Map<String, String> loginData)
    {
        String username = loginData.get("username");
        String password = loginData.get("password");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication =  authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = jwtTokenProvider.createToken(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>(new JwtToken(token), HttpStatus.CREATED);
    }
}
