package testcase;

import base.BaseSetUp;
import base.Product;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AmazonPage;
import pages.EbayPage;
import constants.Common;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestAll extends BaseSetUp {
    List<Product> listProduct1 = new ArrayList<>();
    List<Product> listProduct2 = new ArrayList<>();
    private String nameIphone = "apple iPhone 11";

    @Test(alwaysRun = true)
    public void searchProduct(){
        AmazonPage amazonPage = new AmazonPage(getDriver());
        EbayPage ebayPage = new EbayPage(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        amazonPage.navigateTo(Common.LINK_AMAZON);
        amazonPage.clickSearchTextBox();
        amazonPage.sendKeySearchTextBox(nameIphone);
        amazonPage.clickSearchButton();

        listProduct1 = amazonPage.getListProduct(nameIphone);

        ebayPage.navigateTo(Common.LINK_EBAY);
        ebayPage.clickSearchTextBox();
        ebayPage.sendKeySearchTextBox(nameIphone);
        listProduct2 = ebayPage.getProductEbay(nameIphone);

        listProduct1.addAll(listProduct2);
        amazonPage.SortProduct(listProduct1);
        for(Product pro: listProduct1){
            pro.show();
        }
    }
}