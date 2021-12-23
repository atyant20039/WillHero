package com.example.willhero;

public class User {
    private Hero hero;
    private Game game;
    private int myScore = 0;

    User(){

    }

    public int getScore() {
        return myScore;
    }

    public void setScore(int myScore) {
        this.myScore = myScore;
    }

    public Hero getHero() {
        return hero;
    }

    public void pauseGame(){

    }

    public void resumeGame(){

    }

    public void saveGame(){

    }

    public void toMainMenu(){

    }
}
