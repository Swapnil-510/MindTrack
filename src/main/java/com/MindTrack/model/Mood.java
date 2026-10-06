package com.MindTrack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "moods")
public class Mood {

    @Id
    private String id;

    private int moodScore;

    private String userEmail;

    private String mood;

    private String date;

    // -------- ID --------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // -------- Mood Score --------

    public int getMoodScore() {
        return moodScore;
    }

    public void setMoodScore(int moodScore) {
        this.moodScore = moodScore;
    }

    // -------- User Email --------

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // -------- Mood --------

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    // -------- Date --------

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}