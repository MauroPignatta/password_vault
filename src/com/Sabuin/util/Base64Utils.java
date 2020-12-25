package com.Sabuin.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.nio.charset.StandardCharsets;

public class Base64Utils {

    public static String encode(String text) {
        return Base64.encode(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String encodedText){
        return new String(Base64.decode(encodedText));
    }

}
