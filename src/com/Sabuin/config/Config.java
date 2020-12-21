package com.Sabuin.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Properties;

public class Config {

    public static final int PASSWORD_MIN_LENGTH = 8;
    public static final int PASSWORD_MAX_LENGTH = 128;

    private static final String PROP_LENGTH = "pass_length";
    private static final String PROP_SYMBOLS = "use_symbols";

    private static Config config;
    private final Properties properties;
    private final Gson gson;

    private File configFile;
    private String homePath;

    private Config(){
        properties = new Properties();
        gson = new GsonBuilder().serializeNulls().create();
        addDefaultValues();
        loadConfigFile();
    }

    private void addDefaultValues() {
        setPassLength(16);
        setUseSymbols(false);
    }

    private void loadConfigFile() {
        homePath = System.getProperty("user.home") + "\\AppData\\Roaming\\PasswordVault";
        File appFolder = new File(homePath);

        appFolder.mkdir();

        configFile = new File(homePath + "\\config.ini");
        try {
            if(configFile.createNewFile()){
                save();
            } else {
                loadConfigFromFile(configFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void loadConfigFromFile(File configFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(configFile);
        properties.load(inputStream);

        setPassLength(getAsInt(PROP_LENGTH));
        setUseSymbols(getAsBoolean(PROP_SYMBOLS));

        inputStream.close();
    }

    public void save() {
        try {
            OutputStream outputStream = new FileOutputStream(configFile);
            properties.store(outputStream, "Archivo de configuracion de Password Vault");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getConfig(){
        if(config == null){
            config = new Config();
        }

        return config;
    }

    private String get(String key){
        return properties.getProperty(key);
    }

    private int getAsInt(String key) {
        return Integer.parseInt(get(key));
    }

    private boolean getAsBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public int getPassLength() {
        return getAsInt(PROP_LENGTH);
    }

    public void setPassLength(int length) {
        int passLength = Math.min(PASSWORD_MAX_LENGTH, Math.max(PASSWORD_MIN_LENGTH, length));
        properties.put(PROP_LENGTH, String.valueOf(passLength));
    }

    public Gson getGson() {
        return gson;
    }

    public String getHomePath() {
        return homePath;
    }

    public boolean getUseSymbols() {
        return getAsBoolean(PROP_SYMBOLS);
    }

    public void setUseSymbols(boolean useSymbols) {
        properties.put(PROP_SYMBOLS, String.valueOf(useSymbols));
    }
}
