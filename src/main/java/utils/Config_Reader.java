package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_Reader {
    private Properties prop;

    public Properties ed_prop() throws FileNotFoundException, IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
        prop.load(ip);
        return prop;
    }
}


