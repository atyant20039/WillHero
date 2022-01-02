package com.example.willhero;

import java.io.Serializable;

public class User implements Serializable {
    private Hero hero;
    private Game game;
    private int myScore = 0, myCoin = 0;

    User(){
        hero = new Hero(1300,300, this);
    }

    public int getCoin() {
        return myCoin;
    }

    public void setCoin(int myCoin) {
        this.myCoin = myCoin;
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
