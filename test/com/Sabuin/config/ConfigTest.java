package com.Sabuin.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    public void setPasswordLength_shortPasswordLength(){
        Config config = Config.getConfig();
        config.setPassLength(4);
        assertEquals(Config.PASSWORD_MIN_LENGTH, config.getPassLength());
    }

    @Test
    public void setPasswordLength_longPasswordLength(){
        Config config = Config.getConfig();
        config.setPassLength(3333);
        assertEquals(Config.PASSWORD_MAX_LENGTH, config.getPassLength());
    }

    @Test
    public void setPasswordLength_inRangePasswordLength(){
        Config config = Config.getConfig();
        int len = 22;
        config.setPassLength(len);
        assertEquals(len, config.getPassLength());
    }





}