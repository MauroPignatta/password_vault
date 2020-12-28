package com.Sabuin.entity;

import java.net.URL;

public class Registry {

    private String name;
    private URL url;
    private Account account;
    private String description;

    public Registry() {
    }

    public Registry(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public Registry(String name, Account account, String description) {
        this.name = name;
        this.account = account;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "Name=" + name +
                "\nUrl=" + url +
                "\nUsername=" + account.getUsername() +
                "\nDescription=" + description;
    }
}
