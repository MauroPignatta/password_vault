package com.Sabuin.manager;

import com.Sabuin.config.Config;
import com.Sabuin.entity.Registry;
import com.Sabuin.file.BinaryFile;
import com.Sabuin.log.Log;
import com.Sabuin.log.LogType;
import com.Sabuin.util.Base64Utils;
import com.google.gson.Gson;

import java.util.*;

public class RegistryManager {

    private List<Registry> registries;
    private String username;
    private BinaryFile file;

    public RegistryManager( String username) {
        this.username = username;
        file = new BinaryFile("users", Base64Utils.encode(username) + ".psv");
        this.registries = loadRegistries(file);
    }

    private List<Registry> loadRegistries(BinaryFile file) {
        List<Registry> list = new ArrayList<>();
        try{
            String fileContent = file.read();
            if(!fileContent.isEmpty()){
                String json = Base64Utils.decode(fileContent);
                Registry[] savedRegistries = Config.getConfig().getGson().fromJson(json, Registry[].class);
                list = Arrays.asList(savedRegistries);
            }
        } catch (Exception e){
            System.err.println(new Log(LogType.ERROR,
                    "An error occurred trying to load " + file.getPath()));
        }
        return new ArrayList<>(list);
    }

    private void saveRegistries(){
        Gson gson = Config.getConfig().getGson();
        file.write(Base64Utils.encode(gson.toJson(registries.toArray(), Registry[].class)));
    }

    public void addRegistry(Registry registry){
        registries.add(registry);
        saveRegistries();
    }

    public void deleteRegistry(Registry registry){
        registries.remove(registry);
        saveRegistries();
    }

}
