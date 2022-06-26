package com.challenge.popcornplus.entities.enums;

public enum UserRanking {
    READER("READER"),
    BASIC("BASIC"),
    ADVANCED("ADVANCED"),
    MODERATOR("MODERATOR");

    private final String userRanking;

    UserRanking(String userRanking) {
        this.userRanking = userRanking;
    }

    public String getUserRanking() {
        return userRanking;
    }

    public static UserRanking getRanking(String userRanking) {
        for (UserRanking ranking : UserRanking.values()) {
            if (ranking.name().equals(userRanking)) {
                return  ranking;
            }
        }
        throw new IllegalArgumentException("Invalid Ranking!");
    }
}
