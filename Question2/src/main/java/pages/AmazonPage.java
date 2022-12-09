package pages;

import base.BasePage;
import object.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonPage extends BasePage {
    private String nameProduct = ".//span[@class='a-size-medium a-color-base a-text-normal']";
    private String priceProduct = ".//span[@class='a-price-whole']";
    private String linkProduct = ".//div[@class='a-section']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
    @FindBy(name = "field-keywords")
    private WebElement searchTextBox;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement buttonSearch;
    @FindBy(xpath = "(//div[@id='s-skipLinkTargetForMainSearchResults']/following-sibling::span[1]//div)[1]//div[@data-component-type='s-search-result']")
    private List<WebElement> listProduct;
    private  WebDriver driver;
    public AmazonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickSearchTextBox(){
        clickElement(searchTextBox);
    }
    public void sendKeySearchTextBox(String value){
        sendKeyElement(searchTextBox, value);
    }
    public void clickSearchButton(){
        clickElement(buttonSearch);
    }
    public List<Product> getListProduct (String namePro){
        List<Product> ls = new ArrayList<>();
        String title = getDriver().getTitle();
        for (WebElement pro : listProduct) {
            String name = pro.findElement(By.xpath(this.nameProduct)).getText();
            if (name.toLowerCase().contains(namePro.toLowerCase())) {
                Product product = new Product();
                try {
                    double price = Double.parseDouble(pro.findElement(By.xpath(priceProduct)).getText().replace(",", ""));
                    String link = pro.findElement(By.xpath(linkProduct)).getAttribute("href");
                    product.setName(name);
                    product.setPrice(price);
                    product.setLink(link);
                    product.setWebSite(title);
                } catch (NoSuchElementException e) {
                    continue;
                }
                ls.add(product);
            }
        }
        return ls;
    }
    public void sortProduct(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }
}