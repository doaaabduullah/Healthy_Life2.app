package com.example.healthylife2;

public class PersonalDetails {
    private String currentWeight;
    private String height;
    private String goalWeight;

    public PersonalDetails() {
        // Empty constructor required for Firebase
    }

    public PersonalDetails(String currentWeight, String height, String goalWeight) {
        this.currentWeight = currentWeight;
        this.height = height;
        this.goalWeight = goalWeight;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public String getHeight() {
        return height;
    }

    public String getGoalWeight() {
        return goalWeight;
    }
}

