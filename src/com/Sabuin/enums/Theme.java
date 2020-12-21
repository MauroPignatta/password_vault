package com.Sabuin.enums;

public enum Theme {

    DARK_RED("Dark Red"), LIGHT_RED("Light Red");
    private String text;

    Theme(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
