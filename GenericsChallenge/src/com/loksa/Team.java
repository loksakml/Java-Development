package com.loksa;

public abstract class Team implements Comparable<Team> {
    private String name;
    private int score;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Team team) {
        if (this.score > team.score) {
            return -1;
        } else if (this.score < team.score) {
            return 1;
        } else {
            return 0;
        }
    }



    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
