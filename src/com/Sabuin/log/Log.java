package com.Sabuin.log;

import java.time.LocalDateTime;

public class Log {

    private String date;
    private LogType logType;
    private String message;

    public Log(LogType logType, String message) {
        this.date = LocalDateTime.now().toString();
        this.date = date.replaceFirst("T", " ");
        this.date = date.replaceFirst("\\.([\\d]{3})", "");
        this.logType = logType;
        this.message = message;
    }

    @Override
    public String toString() {
        String thread = Thread.currentThread().getName();
        return "["+ logType.name() + " " + date +"][" + thread + "] : " + message;
    }
}
