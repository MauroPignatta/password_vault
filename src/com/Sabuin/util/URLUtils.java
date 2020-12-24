package com.Sabuin.util;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils {

    public static URL getFavicon(URL url) throws MalformedURLException {
        return new URL(url.getProtocol() + "://" + url.getHost() + "/favicon.ico");
    }

    public static URL getFavicon(String url) throws MalformedURLException {
        return getFavicon(new URL(url));
    }

}
