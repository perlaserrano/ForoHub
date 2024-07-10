package com.alura.challenge.forohub.forochallenge.repository;

import com.alura.challenge.forohub.forochallenge.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}
