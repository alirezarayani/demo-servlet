package ir.lazydeveloper.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private final String path;
    private final InputStream resourceAsStream;
    private Properties properties;

    public PropertyUtil(String path) {
        this.path = path;
        this.resourceAsStream = PropertyUtil.class.getClassLoader().getResourceAsStream(this.path);
        try {
            this.properties = new Properties();
            this.properties.load(this.resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}
