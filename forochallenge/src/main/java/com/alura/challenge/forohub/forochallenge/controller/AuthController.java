package com.alura.challenge.forohub.forochallenge.controller;

import com.alura.challenge.forohub.forochallenge.domain.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        // Genera el token JWT aquí y retorna
        return "JWT Token";
    }

    static class AuthRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Getters y Setters
    }
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        // Aquí puedes obtener las autoridades del usuario y convertirlas a una lista de strings
//        String jwt = jwtTokenProvider.createToken(userDetails.getUsername(),
//                userDetails.getAuthorities().stream()
//                        .map(grantedAuthority -> grantedAuthority.getAuthority())
//                        .collect(Collectors.toList()));
//
//        return ResponseEntity.ok(new JwtResponse(jwt));
//    }
//
//    public static class LoginRequest {
//        private String username;
//        private String password;
//
//        // Getters y setters
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//
//    public static class JwtResponse {
//        private String token;
//
//        public JwtResponse(String token) {
//            this.token = token;
//        }
//
//        public String getToken() {
//            return token;
//        }
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//    }
}
