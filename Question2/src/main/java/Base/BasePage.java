package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final int TIME_OUT = 10;
    protected  WebDriver driver;
    private  WebDriverWait wait;
    private Actions action;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
         action = new Actions(driver);
    }
    public WebDriverWait getExplicitWait() {
        return wait;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void navigateTo(String url){
        getDriver().get(url);
    }
    public void clickElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(e));
        e.click();
    }
    public void sendKeyElement(WebElement e, String key){
        getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(e));
        e.sendKeys(key);
    }
}
