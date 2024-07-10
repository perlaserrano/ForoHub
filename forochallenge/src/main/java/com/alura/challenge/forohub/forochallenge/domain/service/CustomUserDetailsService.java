package com.alura.challenge.forohub.forochallenge.domain.service;

import com.alura.challenge.forohub.forochallenge.entity.User;
import com.alura.challenge.forohub.forochallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Asegúrate de manejar correctamente la encriptación de contraseñas
                .roles(user.getRoles().toArray(new String[0])) // Convertir la lista de roles a un array de String
                .build();
    }
}
