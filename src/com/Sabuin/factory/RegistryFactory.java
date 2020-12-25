package com.Sabuin.factory;

import com.Sabuin.config.Config;
import com.Sabuin.entity.Account;
import com.Sabuin.entity.Registry;

public class RegistryFactory {

    public Registry createRegistry(String name, Account account){
        Registry registry = new Registry();
        registry.setName(name);
        registry.setAccount(account);

        return registry;
    }

    public Registry createRegistry(String json){
        return Config.getConfig().getGson().fromJson(json, Registry.class);
    }

}
