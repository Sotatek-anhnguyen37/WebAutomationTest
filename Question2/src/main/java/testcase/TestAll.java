package testcase;

import base.BaseSetUp;
import object.Product;
import pages.AmazonPage;
import pages.EbayPage;
import constants.Common;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestAll extends BaseSetUp {
    List<Product> listProduct1 = new ArrayList<>();
    List<Product> listProduct2 = new ArrayList<>();
    private String nameIphone = "iPhone 11";

    @Test( priority = 0)
    public void searchProductAmazon() {
        AmazonPage amazonPage = new AmazonPage(getDriver());
        amazonPage.navigateTo(Common.LINK_AMAZON);
        amazonPage.clickSearchTextBox();
        amazonPage.sendKeySearchTextBox(nameIphone);
        amazonPage.clickSearchButton();

        listProduct1 = amazonPage.getListProduct(nameIphone);
    }
    @Test(priority = 1)
    public void searchProductEbay() {
        EbayPage ebayPage = new EbayPage(getDriver());
        AmazonPage amazonPage = new AmazonPage(getDriver());

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
