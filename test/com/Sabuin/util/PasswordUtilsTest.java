package com.Sabuin.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

    @Test
    public void passwordStrength_veryStrong(){
        String password = "Aa123456!@#!!@#!@#";
        String expected = "Very Strong";

        assertEquals(expected, PasswordUtils.checkPasswordStrength(password));
    }

    @Test
    public void passwordStrength_strong(){
        String password = "Aa123456!";
        String expected = "Strong";

        assertEquals(expected, PasswordUtils.checkPasswordStrength(password));
    }

    @Test
    public void passwordStrength_medium(){
        String password = "Aa123456";
        String expected = "Medium";

        assertEquals(expected, PasswordUtils.checkPasswordStrength(password));
    }

    @Test
    public void passwordStrength_weak(){
        String password = "Aa12345";
        String expected = "Weak";

        assertEquals(expected, PasswordUtils.checkPasswordStrength(password));
    }

    @Test
    public void passwordStrength_veryWeak(){
        String password = "asdasd";
        String expected = "Very Weak";

        assertEquals(expected, PasswordUtils.checkPasswordStrength(password));
    }

    @Test
    public void passwordStrength_fail_emptyString(){
        String password = "";

        assertTrue(PasswordUtils.checkPasswordStrength(password).contains("Failed"));
    }

    @Test
    public void passwordStrength_fail_nullString(){
        assertTrue(PasswordUtils.checkPasswordStrength(null).contains("Failed"));
    }

}