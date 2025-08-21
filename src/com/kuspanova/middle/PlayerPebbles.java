package com.kuspanova.middle;

public class PlayerPebbles {
    private String name;
    private int countVictories;

    public PlayerPebbles(int countVictories, String name) {
        this.countVictories = countVictories;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountVictories() {
        return countVictories;
    }

    public void setCountVictories(int countVictories) {
        this.countVictories = countVictories;
    }
}
