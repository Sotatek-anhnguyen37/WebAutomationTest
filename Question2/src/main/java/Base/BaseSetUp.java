package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetUp {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeClass
    @Parameters({"autoTestWeb"})
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
