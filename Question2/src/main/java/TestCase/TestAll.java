package TestCase;

import Base.BaseSetUp;
import Base.Product;
import Pages.AmazonPage;
import Pages.EbayPage;
import Constants.Common;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TestAll extends BaseSetUp {
    List<Product> ls1 = new ArrayList<>();
    List<Product> ls2 = new ArrayList<>();
    private String nameIphone = "apple iPhone 11";
    private String key = "iPhone 11";
    @Test(alwaysRun = true)
    public void searchProduct(){
        AmazonPage amazonPage = new AmazonPage(getDriver());
        amazonPage.navigateTo(Common.linkAmazon);
        amazonPage.SearchProduct(key);
        ls1 = amazonPage.getListProduct(nameIphone);
        EbayPage ebayPage = new EbayPage(getDriver());
        ebayPage.navigateTo(Common.linkEbay);
        ebayPage.SearchProduct(key);
        ls2 = ebayPage.getProductEbay(nameIphone);

        ls1.addAll(ls2);
        amazonPage.SortProduct(ls1);
        for(Product pro: ls1){
            pro.Show();
        }
    }
}