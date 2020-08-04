package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private final Properties properties = new Properties();

    private static PropertyManager INSTANCE = null;

    private PropertyManager() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("env", "application1") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyManager initProperties() {
        if (INSTANCE == null) {
            INSTANCE = new PropertyManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
