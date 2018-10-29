package com.metronom.test.tictactoe.domain;

public class Player {

    private String name;
    private char value;
    private boolean human = true;

    public Player(char value, boolean human){
        this.value = value;
        this.name = value +"";
        this.human = human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getValue() {
        return value;
    }


    public boolean isHuman() {
        return human;
    }
}
