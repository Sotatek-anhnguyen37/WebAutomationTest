package pages;

import base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ScreenShoot extends BasePage {
    public ScreenShoot(WebDriver driver) {
        super(driver);
    }

    public void takeScreenShoot(Method result) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        // Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
        //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
        File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
        FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
        System.out.println("Đã chụp màn hình: " + result.getName());
    }
}
