package com.Sabuin.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class URLUtils {

    public static URL toURL(String url){
        try{
            if(verifyURL(url))
                if(!hasProtocol(url))
                    url = addProtocol(url);
                return new URL(url);
        } catch (MalformedURLException ignored){}
        return null;
    }

    private static String addProtocol(String url){
        return "http://" + url;
    }

    private static boolean hasProtocol(String url){
        return Pattern.matches("https?:\\/\\/", url);
    }

    public static boolean verifyURL(String url){
        if(!hasProtocol(url)){
            url = addProtocol(url);
        }
        String withHttpRegex = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
        return Pattern.matches(withHttpRegex, url);
    }

    public static URL getFavicon(URL url) {
        return toURL(url.getProtocol() + "://" + url.getHost() + "/favicon.ico");
    }

    public static URL getFavicon(String url) {
        try{
            return getFavicon(new URL(url));
        } catch (MalformedURLException ignored){}
        return null;
    }

}
