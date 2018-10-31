package com.metronom.test.tictactoe.configuration;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class ConfigurationLoaderTest {

    @Test
    public void getPropertyPlayerChar_invalid_value_for_char_player_Test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();
        properties.setProperty("TEST1", "MORE_THAN_ONE_CHAR");

        configurationLoader.setProperty(properties);

        try {
            configurationLoader.getPropertyPlayerChar("TEST1");
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception",
                    e.getMessage().contains("the property is not a single character: "));
        }
    }

    @Test
    public void getPropertyPlayerChar_property_not_found_Test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();
        configurationLoader.setProperty(properties);

        try {
            configurationLoader.getPropertyPlayerChar("TEST1");
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception",
                    e.getMessage().contains("Property not found: "));
        }
    }

    @Test
    public void getPropertyPlayerChar_valid_value_for_char_player_Test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();
        char value = 'V';
        properties.setProperty("TEST1", ""+value);

        configurationLoader.setProperty(properties);

        char result = 0;
        try {
            result = configurationLoader.getPropertyPlayerChar("TEST1");
        } catch (ConfigurationException e) {
            Assert.fail("Unexpected Exception "+ e.getMessage());
        }
        Assert.assertTrue("retrieved char sould be" + value, result == value);
    }

    @Test
    public void getPropertySize_invalid_value_Test()  {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        properties.setProperty("boardSize", "V");

        configurationLoader.setProperty(properties);

        try {
            int result = configurationLoader.getPropertySize();
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception",
                    e.getMessage().contains("The property is not a valid number: "));
        }
    }

    @Test
    public void getPropertySize_invalid_size_Test()  {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        properties.setProperty("boardSize", "11");

        configurationLoader.setProperty(properties);

        try {
            int result = configurationLoader.getPropertySize();
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception",
                    e.getMessage().contains("Should be a value between 3 and 10"));
        }
    }

    @Test
    public void getPropertySize_invalid_size2_Test()  {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        properties.setProperty("boardSize", "2");

        configurationLoader.setProperty(properties);

        try {
            int result = configurationLoader.getPropertySize();
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception",
                    e.getMessage().contains("Should be a value between 3 and 10"));
        }
    }


    @Test
    public void getPropertySize_valid_value_Test() throws ConfigurationException {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        int value = 3;
        properties.setProperty(ConfigurationLoader.PROPERTY_SIZE, ""+value);

        configurationLoader.setProperty(properties);

        int result = configurationLoader.getPropertySize();
        Assert.assertTrue("result should be "+ value, result == 3);
    }

    @Test
    public void buildConfiguration_valid_test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        int value1 = 3;
        char value2 = 'A';
        char value3 = 'B';
        char value4 = 'C';

        properties.setProperty(ConfigurationLoader.PROPERTY_SIZE, ""+value1);
        properties.setProperty(ConfigurationLoader.PROPERTY_PLAYER_1, ""+value2);
        properties.setProperty(ConfigurationLoader.PROPERTY_PLAYER_2, ""+value3);
        properties.setProperty(ConfigurationLoader.PROPERTY_PLAYER_3, ""+value4);

        configurationLoader.setProperty(properties);

        //if(properties == null)
         //   throw new ConfigurationException("Property file not loaded");
        Configuration configuration = null;
        try {
            configuration = configurationLoader.buildConfiguration();
        } catch (ConfigurationException e) {
            Assert.fail("Unexpected Exception "+ e.getMessage());
        }

        Assert.assertTrue("Board size incorrect", configuration.boardSize == value1);
        Assert.assertTrue("char p1 incorrect", configuration.player1Char == value2);
        Assert.assertTrue("char p2 incorrect", configuration.player2Char == value3);
        Assert.assertTrue("char p3 incorrect", configuration.player3Char == value4);

    }

    @Test
    public void buildConfiguration_null_properties_test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        Properties properties = new Properties();

        configurationLoader.setProperty(null);

        try {
            configurationLoader.buildConfiguration();
            Assert.fail("Expected Exception");
        } catch (ConfigurationException e) {
            Assert.assertTrue("Incorrect exception" ,e.getMessage().contains("Property file not loaded"));
        }
    }

    @Test
    public void load_from_resources_test() {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();

        Configuration value = null;
        try {
            value = configurationLoader.load();
        } catch (ConfigurationException e) {
            Assert.fail("Unexpected Exception "+ e.getMessage());
        }
        Assert.assertTrue(value.boardSize == 10);


    }


}
