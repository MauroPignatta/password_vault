package com.Sabuin.factory;

import com.Sabuin.config.Config;
import com.Sabuin.entity.Account;
import com.Sabuin.entity.Registry;

import java.net.URL;

public class RegistryFactory {

    private Registry registry;

    public RegistryFactory(){
        registry = new Registry();
    }

    public RegistryFactory setName(String name){
        registry.setName(name);
        return this;
    }

    public RegistryFactory setAccount(Account account){
        registry.setAccount(account);
        return this;
    }

    public RegistryFactory setURL(URL url){
        registry.setUrl(url);
        return this;
    }

    public RegistryFactory setDescription(String desc){
        registry.setDescription(desc);
        return this;
    }

    public Registry build(){
        Registry returnedRegistry = registry;
        registry = new Registry();
        return returnedRegistry;
    }

    public Registry createRegistry(String json){
        return Config.getConfig().getGson().fromJson(json, Registry.class);
    }

}
