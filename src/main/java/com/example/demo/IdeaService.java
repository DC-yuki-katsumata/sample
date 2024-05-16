package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public Idea saveIdea(String title, String content) {
        Idea idea = new Idea(title, LocalDateTime.now(), content);
        return ideaRepository.save(idea);
    }
}
