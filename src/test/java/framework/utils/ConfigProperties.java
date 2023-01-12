package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static Properties property;
    private static String configPath = "src/test/resources/framework/settings/config.properties";

    public static String getValue(String value) {
        property = new Properties();
        try {
            InputStream insStm = new FileInputStream(configPath);
            property.load(insStm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property.getProperty(value);
    }
}
