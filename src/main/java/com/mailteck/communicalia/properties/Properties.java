package com.mailteck.communicalia.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Properties {

    private static final Logger logger = LogManager.getLogger(Properties.class);

    private static PropertiesReader reader;

    public static PropertiesReader getReader(PropertiesReader reader) {
        if (reader == null) {
            try {
                reader = new PropertiesReader("prod.properties");
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return reader;
    }

    public static String getProperties(String value) {

        reader = getReader(reader);
        String property = reader.getProperty(value);
        return property;
    }



}
