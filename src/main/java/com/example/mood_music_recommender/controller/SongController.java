package com.example.mood_music_recommender.controller;

import com.example.mood_music_recommender.model.Song;
import com.example.mood_music_recommender.service.MusicRecommendationService;
import com.example.mood_music_recommender.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final MusicRecommendationService musicRecommendationService;
    private final SongRepository songRepository;

    @Autowired
    public SongController(MusicRecommendationService musicRecommendationService, SongRepository songRepository) {
        this.musicRecommendationService = musicRecommendationService;
        this.songRepository = songRepository;
    }


    // Create a new song with duplicate check
    @PostMapping
    public ResponseEntity<String> createSong(@Valid @RequestBody Song song) {
        return musicRecommendationService.addSong(song);
    }

    // Read all songs
    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // Read a song by ID
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Optional<Song> song = songRepository.findById(id);
        return song.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a song by ID
    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @Valid @RequestBody Song songDetails) {
        return songRepository.findById(id).map(song -> {
            song.setName(songDetails.getName());
            song.setAlbum(songDetails.getAlbum());
            song.setArtist(songDetails.getArtist());
            song.setMood(songDetails.getMood());
            Song updatedSong = songRepository.save(song);
            return ResponseEntity.ok(updatedSong);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a song by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
