package testcase;

import base.BaseSetUp;
import object.Product;

import pages.AmazonPage;
import pages.EbayPage;
import org.testng.annotations.Listeners;
import pages.*;

import constants.Common;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(TestListener.class)
public class TestAll extends BaseSetUp {
    @Test(description = "D.A")
    public void searchProduct() {
        List<Product> listProduct1;
        List<Product> listProduct2;
        String nameIphone = "iPhone 11";
        EbayPage ebayPage = new EbayPage(getDriver());
        ebayPage.navigateTo(Common.LINK_EBAY);
        ebayPage.clickSearchTextBox();
        ebayPage.sendKeySearchTextBox(nameIphone);
        ebayPage.clickSearchButton();
        listProduct1 = ebayPage.getProductEbay("Apple " + nameIphone);

        AmazonPage amazonPage = new AmazonPage(getDriver());
        amazonPage.navigateTo(Common.LINK_AMAZON);
        amazonPage.clickSearchTextBox();
        amazonPage.sendKeySearchTextBox(nameIphone);
        amazonPage.clickSearchButton();
        getDriver().getTitle();
        listProduct2 = amazonPage.getListProduct("Apple " + nameIphone);
        listProduct1.addAll(listProduct2);

        amazonPage.sortProduct(listProduct1);
        for (Product pro : listProduct1) {
            pro.show();
        }
    }
}
