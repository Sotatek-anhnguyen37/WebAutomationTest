package pages;

import base.BasePage;
import object.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class EbayPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "gh-ac")
    private WebElement SearchTextBox;
    @FindBy(id = "gh-btn")
    private WebElement SearchButton;
    @FindBy(xpath = "//div[@class=\"srp-river-results clearfix\"]//div[@class=\"s-item__wrapper clearfix\"]")
    private List<WebElement> listProduct1;

    public EbayPage(WebDriver driver) {
        super(driver);
        this.driver  = driver;
    }
    public void clickSearchTextBox(){
        clickElement(SearchTextBox);
    }
    public void sendKeySearchTextBox(String value){
        sendKeyElement(SearchTextBox, value);
    }
    public void clickSearchButton(){
        clickElement(SearchButton);
    }
    public List<Product> getProductEbay (String nameProduct){
        List<Product> ls = new ArrayList<>();
        String title = getDriver().getTitle();
        for(WebElement pro : listProduct1){
            String name = pro.findElement(By.xpath(".//span[@role=\"heading\"]")).getText();
            if(name.toUpperCase().contains(nameProduct.toUpperCase())  ){
               Product product = new Product();
               try {
                  String link = pro.findElement(By.xpath(".//a[@class=\"s-item__link\"]")).getAttribute("href");
                   double price = Double.parseDouble(pro.findElement(By.xpath(".//span[@class=\"s-item__price\"]")).getText().replace(",","").replace(" VND",""));
                   product.setName(name);
                   product.setLink(link);
                   product.setPrice(price/23000);
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