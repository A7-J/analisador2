package com.example.analisador.model;

public class AnalysisResult {
    public String passwordHash;
    public String strength;
    public int score;
    public String timestamp;

    public AnalysisResult(String passwordHash, String strength, int score, String timestamp) {
        this.passwordHash = passwordHash;
        this.strength = strength;
        this.score = score;
        this.timestamp = timestamp;
    }
}
