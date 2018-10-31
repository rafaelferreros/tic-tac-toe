package com.metronom.test.tictactoe.model.players;

public class HumanPlayer implements Player {

    private String name;
    private char value;

    public HumanPlayer(char value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getValue() {
        return value;
    }

}
