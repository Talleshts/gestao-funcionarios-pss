/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.sistemalog;

import org.apache.logging.log4j.spi.LoggerAdapter;

/**
 *
 * @author tallesh
 */
public class LoggerConfig {
    private static LoggerAdapter loggerAdapter;

    public static void setLoggerAdapter(LoggerAdapter adapter) {
        loggerAdapter = adapter;
    }

    public static LoggerAdapter getLoggerAdapter() {
        return loggerAdapter;
    }
    
}
