package com.example.mood_music_recommender.repository;

import com.example.mood_music_recommender.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    boolean existsByNameAndArtist(String name, String artist);
    List<Song> findByMood(String mood);
}
