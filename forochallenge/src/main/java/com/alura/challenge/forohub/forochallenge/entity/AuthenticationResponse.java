package com.alura.challenge.forohub.forochallenge.entity;

public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter
    public String getJwt() {
        return jwt;
    }
}
