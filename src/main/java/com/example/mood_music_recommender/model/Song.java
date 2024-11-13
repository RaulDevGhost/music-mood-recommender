package com.example.mood_music_recommender.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(
        name = "songs",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "artist"})
)
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Album is required")
    private String album;

    @NotEmpty(message = "Artist is required")
    private String artist;

    @NotEmpty(message = "Mood is required")
    private String mood;

    public Song() {}

    public Song(String name, String album, String artist, String mood) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.mood = mood;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }
}
