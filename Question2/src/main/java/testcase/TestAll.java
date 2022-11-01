package testcase;


import base.BaseSetUp;
import object.Product;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;
import constants.Common;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
@Listeners(TestListioner.class)
public class TestAll extends BaseSetUp {
    List<Product> listProduct1 = new ArrayList<>();
    List<Product> listProduct2 = new ArrayList<>();
    private String nameIphone = "iPhone 11";
    @BeforeClass
    public void setUpClass() throws Exception {
        RecordVideo.startRecord("ManagerDocument");
    }

    @Test( priority = 0)
    public void searchProductAmazon(Method result) throws IOException {
        AmazonPage amazonPage = new AmazonPage(getDriver());
        ScreenShoot screenShoot = new ScreenShoot();

        amazonPage.navigateTo(Common.LINK_AMAZON);
        amazonPage.clickSearchTextBox();
        amazonPage.sendKeySearchTextBox(nameIphone);
        amazonPage.clickSearchButton();
        getDriver().getTitle();
//        screenShoot.takeScreenShoot(result);

        listProduct1 = amazonPage.getListProduct(nameIphone);
    }
    @Test(priority = 1)
    public void searchProductEbay(Method result) throws IOException {
        EbayPage ebayPage = new EbayPage(getDriver());
        AmazonPage amazonPage = new AmazonPage(getDriver());
        ScreenShoot screenShoot = new ScreenShoot();

        ebayPage.navigateTo(Common.LINK_EBAY);
//        screenShoot.takeScreenShoot(result);
        ebayPage.clickSearchTextBox();
        ebayPage.sendKeySearchTextBox(nameIphone);
        listProduct2 = ebayPage.getProductEbay(nameIphone);
        listProduct1.addAll(listProduct2);

        amazonPage.SortProduct(listProduct1);
        for(Product pro: listProduct1){
            pro.show();
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
        RecordVideo.stopRecord();
        getDriver().quit();
    }
}
