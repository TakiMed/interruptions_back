package com.example.predavanjademo.security.jwt;

public class JwtToken {
    private final String token;

    public JwtToken(String token){ this.token = token;}

    public String getToken() {return token;}
}
