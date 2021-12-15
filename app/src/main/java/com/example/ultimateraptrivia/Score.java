package com.example.ultimateraptrivia;

public class Score {
    private int higschore;
    private String name;

    private Score(){}

    public Score(int higschore, String name){
        this.higschore = higschore;
        this.name = name;
    }

    public int getHigschore(){
        return higschore;
    }

    public String getName(){
        return name;
    }

}
