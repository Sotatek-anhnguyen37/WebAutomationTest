package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetUp {
    private WebDriver driver;   // khoi tạo driver dung cho tat ca cac man
    public WebDriver getDriver(){
        return driver;
    }   //tạo ham de cac man khac co the lay driver
    @BeforeClass
    public void SetUp(){                // khoi tao driver cho chrome v
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
