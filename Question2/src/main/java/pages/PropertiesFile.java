package pages;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties = new Properties();
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    String pathProject = System.getProperty("user.dir") + "/";
    String pathRoot = "src/main/resources/account.properties";

    public void setPropertiesFile() throws IOException {
        fileInputStream = new FileInputStream(pathProject+pathRoot);
        System.out.println(pathProject+pathRoot);
        properties.load(fileInputStream);
    }
    public String getValueFile(String key) throws IOException {
        String value = "";
        value = properties.getProperty(key);
//        System.out.println(value);
        return value;
    }
    public void setValueFile(String key, String value) throws IOException {
        fileOutputStream = new FileOutputStream(pathProject+pathRoot);
        properties.setProperty(key, value);
        properties.store(fileOutputStream, "this is a comment");
    }
}
