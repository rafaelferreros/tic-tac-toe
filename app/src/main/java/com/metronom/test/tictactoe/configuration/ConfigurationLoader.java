package com.metronom.test.tictactoe.configuration;

import java.io.*;
import java.util.Properties;

public class ConfigurationLoader {

    private final static String PROPERTY_FILE = "tictactoe.properties";

    protected final static String PROPERTY_SIZE = "boardSize";
    protected final static String PROPERTY_PLAYER_1 = "player1Char";
    protected final static String PROPERTY_PLAYER_2 = "player2Char";
    protected final static String PROPERTY_PLAYER_3 = "player3Char";

    private Properties properties;

    public Configuration load() throws ConfigurationException {

        loadProperties();
        return buildConfiguration();

    }

    protected void loadProperties() throws ConfigurationException {

        if (new File(PROPERTY_FILE).exists()) {
            loadExternalProperties();
        }
        else{
            loadInternalProperties();
        }
    }

    private void loadExternalProperties() throws ConfigurationException {
        File propertyFile = new File(PROPERTY_FILE);

        try(InputStream stream = new FileInputStream(propertyFile)) {
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            throw new ConfigurationException("Error loading configuration file", e);
        }
    }

    private void loadInternalProperties() throws ConfigurationException {

        ClassLoader classLoader = getClass().getClassLoader();

        try(InputStream resourceStream = classLoader.getResourceAsStream(PROPERTY_FILE)) {
            properties = new Properties();
            properties.load(resourceStream);
        }catch (IOException e){
            throw new ConfigurationException("Error loading resources configuration file", e);
        }
    }

    protected Configuration buildConfiguration() throws ConfigurationException {

        if(properties == null)
            throw new ConfigurationException("Property file not loaded");

        Configuration configuration = new Configuration();
        configuration.boardSize = getPropertySize();
        configuration.player1Char = getPropertyPlayerChar(PROPERTY_PLAYER_1);
        configuration.player2Char = getPropertyPlayerChar(PROPERTY_PLAYER_2);
        configuration.player3Char = getPropertyPlayerChar(PROPERTY_PLAYER_3);
        return configuration;
    }

    protected int getPropertySize() throws ConfigurationException {
        String value = properties.getProperty(PROPERTY_SIZE);
        if(value == null || value.isEmpty())
            throw new ConfigurationException("Property not found: " +PROPERTY_SIZE);

        int valueInt = 0;
        try {
            valueInt = Integer.valueOf(value);
        }
        catch (Exception e){
            throw new ConfigurationException("The property is not a valid number: " +PROPERTY_SIZE +" val:" + value, e);
        }

        if(valueInt < 3 || valueInt > 10)
            throw new ConfigurationException(PROPERTY_SIZE +" val:" + value + ", Should be a value between 3 and 10");

        return valueInt;
    }

    protected char getPropertyPlayerChar(String propertyKey) throws ConfigurationException {

        String value = properties.getProperty(propertyKey);

        if(value == null || value.isEmpty())
            throw new ConfigurationException("Property not found: " +propertyKey);

        if(value.length() > 1){
            throw new ConfigurationException("the property is not a single character: "
                    +propertyKey + " val: " + value);
        }
        return value.charAt(0);
    }

    protected void setProperty(Properties properties){
        this.properties = properties;
    }




}
