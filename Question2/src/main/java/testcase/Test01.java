package testcase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PropertiesFile;

import java.io.IOException;

public class Test01 {
    PropertiesFile propertiesFile= new PropertiesFile();
    @BeforeTest
    public void setPropertiesFile() throws IOException {
        propertiesFile.setPropertiesFile();
    }
    @Test(priority = 1)
    public void readFileProperties() throws IOException {
        String value = propertiesFile.getValueFile("fullname");
        String diachi = propertiesFile.getValueFile("diachi");
        System.out.println(value+ " : " + diachi);
    }
    @Test(priority = 0)
    public void writeFileProperties() throws IOException {
        propertiesFile.setValueFile("fullname", "nguyen duc anh");
        propertiesFile.setValueFile("diachi", "trieuloc-hauloc-thanhhoa");
    }
}
