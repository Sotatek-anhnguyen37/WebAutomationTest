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
    @FindBy(name = "field-keywords")
    private WebElement SearchTextBox;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement ButtonSearch;
    @FindBy(xpath = "//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]//div[@class=\"s-card-container s-overflow-hidden aok-relative puis-include-content-margin s-latency-cf-section s-card-border\"]")
    private List<WebElement> listProduct;
    private  WebDriver driver;
    public AmazonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickSearchTextBox(){
        clickElement(SearchTextBox);
    }
    public void sendKeySearchTextBox(String value){
        sendKeyElement(SearchTextBox, value);
    }
    public void clickSearchButton(){
        clickElement(ButtonSearch);
    }
    public List<Product> getListProduct (String nameProduct){
        List<Product> ls = new ArrayList<>();
        String title = getDriver().getTitle();
        for (WebElement pro : listProduct) {
            String name = pro.findElement(By.xpath(".//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).getText();
            if (name.toLowerCase().contains(nameProduct.toLowerCase())) {
                Product product = new Product();
                try {
                    double price = Double.parseDouble(pro.findElement(By.xpath(".//span[@class=\"a-price-whole\"]")).getText().replace(",", ""));
                    String link = pro.findElement(By.xpath(".//div[@class=\"a-section\"]//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).getAttribute("href");
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
    public void SortProduct(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }
}