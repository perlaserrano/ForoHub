package com.alura.challenge.forohub.forochallenge.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("tucontraseña");
        System.out.println(hashedPassword);
    }
}
