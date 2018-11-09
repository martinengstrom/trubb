package me.sigkill.trubb.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Martin Engström on 2018-11-09.
 */
public class PropertiesUtil {
    private static final String PROPERTY_GAME_PORT = "game.port";
    private static final String PROPERTY_GAME_HOST = "game.host";

    Properties properties;

    public PropertiesUtil() {
        properties = new Properties();
        try {
            InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("app.properties");
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getProperty(String property) {
        return properties.getProperty(property);
    }

    public Integer getGamePort() {
        return Integer.valueOf(getProperty(PROPERTY_GAME_PORT));
    }

    public String getGameHost() {
        return getProperty(PROPERTY_GAME_HOST);
    }
}
