package com.alura.challenge.forohub.forochallenge.controller;

import com.alura.challenge.forohub.forochallenge.entity.Topic;
import com.alura.challenge.forohub.forochallenge.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@Valid @RequestBody Topic topic) {
        Topic savedTopic = topicRepository.save(topic);
        return ResponseEntity.ok(savedTopic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        return topicOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @Valid @RequestBody Topic topicDetails) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic existingTopic = optionalTopic.get();
            existingTopic.setTitle(topicDetails.getTitle());
            existingTopic.setContent(topicDetails.getContent());
            // Puedes actualizar más campos según sea necesario
            Topic updatedTopic = topicRepository.save(existingTopic);
            return ResponseEntity.ok(updatedTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
