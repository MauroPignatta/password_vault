package com.Sabuin;

import com.Sabuin.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.file.Files;

public class AppLock {

    private static boolean locked = false;
    public static void init() {
        try {
            new ServerSocket(9999,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));
        }
        catch (IOException e) {
            locked = true;
        }
    }

    public static boolean isLocked() {
        return locked;
    }
}
