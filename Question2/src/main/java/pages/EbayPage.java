package pages;

import base.BasePage;
import object.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class EbayPage extends BasePage {
    private String nameProduct = ".//span[@role='heading']";
    private String priceProduct = ".//span[@class='s-item__price']";
    private String linkProduct = ".//a[@class='s-item__link']";
    @FindBy(id = "gh-ac")
    private WebElement searchTextBox;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='srp-river-results clearfix']//div[@class='s-item__wrapper clearfix']")
    private List<WebElement> listProduct1;

    public EbayPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchTextBox() {
        clickElement(searchTextBox);
    }

    public void sendKeySearchTextBox(String value) {
        sendKeyElement(searchTextBox, value);
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public List<Product> getProductEbay(String namePro) {
        List<Product> ls = new ArrayList<>();
        String title = getDriver().getTitle();
        for (WebElement pro : listProduct1) {
            String name = pro.findElement(By.xpath(this.nameProduct)).getText();
            if (name.toUpperCase().contains(namePro.toUpperCase())) {
                Product product = new Product();
                try {
                    String link = pro.findElement(By.xpath(linkProduct)).getAttribute("href");
                    double price = Double.parseDouble(pro.findElement(By.xpath(priceProduct)).getText().replace(",", "").replace(" VND", ""));
                    product.setName(name);
                    product.setLink(link);
                    product.setPrice(price / 23000);
                    product.setWebSite(title);
                } catch (Exception ex) {
                    continue;
                }
                ls.add(product);
            }
        }
        return ls;
    }
}