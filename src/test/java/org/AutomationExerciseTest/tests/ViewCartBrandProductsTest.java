package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.BrandProductsPage;
import org.AutomationExerciseTest.pages.ProductDetailPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCartBrandProductsTest {
    TabbarPage tabbarPage;
    ProductDetailPage productDetailPage;
    BrandProductsPage brandProductsPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeClass
    public void setUp(){
//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
        tabbarPage = new TabbarPage();
        productDetailPage = new ProductDetailPage();
        brandProductsPage = new BrandProductsPage();
    }

    @Test
    public void testViewCartBrandProducts() throws InterruptedException {

//        3. 'Ürünler' butonuna tıklayın
        tabbarPage.clickProduct();
//        4. Markaların sol taraftaki çubukta görünür olduğunu doğrulayın
//        5. Herhangi bir marka adına tıklayın
        productDetailPage.setViewMarkaList();
        Thread.sleep(1000);
//        6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
        brandProductsPage.verifyProductsPage("https://automationexercise.com/brand_products/Polo");
//        7. Sol taraftaki çubukta herhangi bir marka bağlantısına tıklayın
        productDetailPage.setClickBrand();
//        8. Kullanıcının o marka sayfasına yönlendirildiğini ve ürünleri görebildiğini doğrulayın
        brandProductsPage.verifyProductsPage("https://automationexercise.com/brand_products/H&M");
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
