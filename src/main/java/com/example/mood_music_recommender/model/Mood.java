package com.example.mood_music_recommender.model;

public class Mood {
    private String description;

    public Mood() {}

    public Mood(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
