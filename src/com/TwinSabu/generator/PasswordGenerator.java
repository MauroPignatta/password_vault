package com.TwinSabu.generator;

import com.TwinSabu.config.Config;

import java.util.*;

public class PasswordGenerator {

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
