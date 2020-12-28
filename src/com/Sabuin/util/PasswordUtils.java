package com.Sabuin.util;

import com.Sabuin.config.Config;
import sun.misc.Regexp;

import java.util.*;
import java.util.regex.Pattern;

public class PasswordUtils {

    private final static int LOWER_CASE = 0;
    private final static int UPPER_CASE = 1;
    private final static int NUMERIC = 2;
    private final static int SYMBOLS = 3;

    private static final Random random = new Random();
    private final static String[] charset = {
            "qwertyuiopasdfghjklzxcvnm",
            "QWERTYUIOPASDFGHJKLZXCVBNM",
            "1234567890",
            "!?@#$%^&*"
    };

    public static String generatePassword(){
        int len = Config.getConfig().getPassLength();

        StringBuilder passwordBuilder = new StringBuilder(len);

        passwordBuilder.append(getRandomChar(LOWER_CASE));
        --len;
        passwordBuilder.append(getRandomChar(UPPER_CASE));
        --len;
        passwordBuilder.append(getRandomChar(NUMERIC));
        --len;

        while(len > 0){
            passwordBuilder.append(getRandomChar(Config.getConfig().getUseSymbols()));
            --len;
        }

        return passwordBuilder.toString();
    }

    public static String checkPasswordStrength(String password){
        int score = 0;

        if(password != null){
            score += getLengthScore(password);
            score += getLettersScore(password);
            score += getNumericScore(password);
            score += getSymbolsScore(password);
        }

        return getStrengthByScore(score);
    }

    private static String getStrengthByScore(int score) {
        if(score > 8){ return "Very Strong"; }
        if(score > 6){ return "Strong"; }
        if(score > 4){ return "Medium"; }
        if(score > 2){ return "Weak"; }
        if(score > 0){ return "Very Weak"; }
        return "Failed to check password strength";
    }

    // max Score = 3;
    private static int getSymbolsScore(String password) {
        return contains(password, charset[SYMBOLS]) ? 3 : 0;
    }

    // max Score = 2
    private static int getNumericScore(String password) {
        return contains(password, charset[NUMERIC]) ? 2 : 0;
    }

    // max Score = 2
    private static int getLettersScore(String password) {
        int score = 0;
        if(contains(password, charset[LOWER_CASE])){
            ++score;
        }
        if(contains(password, charset[UPPER_CASE])){
            ++score;
        }

        return score;
    }

    // max Score = 3
    private static int getLengthScore(String password) {
        int score = 0;
        if(password.length() >= 16)
            score = 3;
        else if(password.length() >= 12){
            score = 2;
        } else if (password.length() >= 8)
            score = 1;

        return score;
    }

    private static boolean contains(String src, String set){
        for(int i = 0; i < set.length(); ++i){
            char c = set.charAt(i);
            if(src.contains("" + c)){
                return true;
            }
        }
        return false;
    }

    private static char getRandomChar(boolean symbols){
        int length = symbols ? charset.length : SYMBOLS;
        int index = random.nextInt(length);

        return getRandomChar(index);
    }

    private static char getRandomChar(int charsetIndex){
        int stringLength = charset[charsetIndex].length();

        return charset[charsetIndex].charAt(random.nextInt(stringLength));
    }

    
}
