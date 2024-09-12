package com.example.mood_music_recommender.controller;

import com.example.mood_music_recommender.model.Mood;
import com.example.mood_music_recommender.service.MusicRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoodController {
    private final MusicRecommendationService musicRecommendationService;

    @Autowired
    public MoodController(MusicRecommendationService musicRecommendationService) {
        this.musicRecommendationService = musicRecommendationService;
    }

    @PostMapping("/mood")
    public String processMood(@RequestBody Mood mood) {
        String recommendation = musicRecommendationService.recommendMusic(mood.getDescription());
        return "Based on your mood '" + mood.getDescription() + "', we recommend the song: " + recommendation;
    }
}