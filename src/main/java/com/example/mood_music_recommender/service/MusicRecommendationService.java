package com.example.mood_music_recommender.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MusicRecommendationService {
    public String recommendMusic(String mood) {
        // This is a simple mock implementation
        List<String> happySongs = Arrays.asList("Don't Stop Me Now", "Happy", "Walking on Sunshine");
        List<String> sadSongs = Arrays.asList("Someone Like You", "Hurt", "The Sound of Silence");
        List<String> energeticSongs = Arrays.asList("Eye of the Tiger", "Stronger", "Thunderstruck");

        Random random = new Random();

        if (mood.toLowerCase().contains("happy")) {
            return happySongs.get(random.nextInt(happySongs.size()));
        } else if (mood.toLowerCase().contains("sad")) {
            return sadSongs.get(random.nextInt(sadSongs.size()));
        } else if (mood.toLowerCase().contains("energetic")) {
            return energeticSongs.get(random.nextInt(energeticSongs.size()));
        } else {
            return "Bohemian Rhapsody"; // Default recommendation
        }
    }
}
