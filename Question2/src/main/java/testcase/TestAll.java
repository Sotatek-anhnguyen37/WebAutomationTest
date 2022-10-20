package testcase;

import base.BaseSetUp;
import object.Product;
import org.openqa.selenium.JavascriptExecutor;
import pages.AmazonPage;
import pages.EbayPage;
import constants.Common;
import org.testng.annotations.Test;
import pages.ScreenShoot;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestAll extends BaseSetUp {
    List<Product> listProduct1 = new ArrayList<>();
    List<Product> listProduct2 = new ArrayList<>();
    private String nameIphone = "iPhone 11";

    @Test( priority = 0)
    public void searchProductAmazon(Method result) throws IOException {
        AmazonPage amazonPage = new AmazonPage(getDriver());
        ScreenShoot screenShoot = new ScreenShoot(getDriver());

        amazonPage.navigateTo(Common.LINK_AMAZON);
        amazonPage.clickSearchTextBox();
        amazonPage.sendKeySearchTextBox(nameIphone);
        amazonPage.clickSearchButton();
        screenShoot.takeScreenShoot(result);

        listProduct1 = amazonPage.getListProduct(nameIphone);
    }
    @Test(priority = 1)
    public void searchProductEbay(Method result) throws IOException {
        EbayPage ebayPage = new EbayPage(getDriver());
        AmazonPage amazonPage = new AmazonPage(getDriver());
        ScreenShoot screenShoot = new ScreenShoot(getDriver());

        ebayPage.navigateTo(Common.LINK_EBAY);
        screenShoot.takeScreenShoot(result);
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
