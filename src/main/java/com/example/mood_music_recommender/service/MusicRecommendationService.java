package com.example.mood_music_recommender.service;

import com.example.mood_music_recommender.model.Song;
import com.example.mood_music_recommender.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MusicRecommendationService {

    private final SongRepository songRepository;

    @Autowired
    public MusicRecommendationService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // Method to add a song with duplicate check
    public ResponseEntity<String> addSong(Song song) {
        boolean exists = songRepository.existsByNameAndArtist(song.getName(), song.getArtist());
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Song already exists.");
        }

        songRepository.save(song);
        return ResponseEntity.status(HttpStatus.CREATED).body("Song added successfully.");
    }

    // Method to recommend music based on mood
    public String recommendMusic(String mood) {
        // Fetch songs that match the mood from the database
        List<Song> songs = songRepository.findByMood(mood.toLowerCase());

        // If no songs are found, return a default recommendation
        if (songs.isEmpty()) {
            return "Bohemian Rhapsody"; // Default song recommendation
        }

        // Randomly select a song from the list of songs with the matching mood
        Random random = new Random();
        Song recommendedSong = songs.get(random.nextInt(songs.size()));

        return recommendedSong.getName() + " by " + recommendedSong.getArtist();
    }
}
