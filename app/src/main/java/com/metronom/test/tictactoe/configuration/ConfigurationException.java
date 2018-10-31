package com.metronom.test.tictactoe.configuration;

public class ConfigurationException extends Exception {

    public ConfigurationException(String message, Exception e){
        super(message, e);
    }

    public ConfigurationException(String message) {
        super(message);
    }
}
