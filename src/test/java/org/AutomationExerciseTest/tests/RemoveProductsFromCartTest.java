package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveProductsFromCartTest {
    ReusableMethods reusableMethods;
    AddProductInCartPage addProductInCartPage;
    TabbarPage tabbarPage;
    ViewCartPage viewCartPage;
    HomeProductsPage homeProductsPage;
    HomePage homePage;
    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp(){
        reusableMethods = new ReusableMethods();
        addProductInCartPage= new AddProductInCartPage();
        tabbarPage = new TabbarPage();
        viewCartPage = new ViewCartPage();
        homeProductsPage = new HomeProductsPage();
        homePage = new HomePage();
        // Tarayıcıyı başlatın
        //'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
    }

    @Test
    public void testRemoveProductsFromCart() throws InterruptedException {
    //Ana sayfanın başarıyla görünür olduğunu doğrulayın
    reusableMethods.verifyHomePage();

    //Ürünleri sepete ekleyin
    homeProductsPage.clickAddToCart();

    //'Sepet' butonuna tıklayın
    homePage.setViewCartButtonClick();

    //Sepet sayfasının görüntülendiğini doğrulayın
    viewCartPage.verifyViewCart();

    //Sepet sayfasının görüntülendiğini doğrulayın
     viewCartPage.verifyViewCart();
    //Belirli ürüne karşılık gelen 'X' düğmesine tıklayın
    viewCartPage.setClickCartQuantityDelete();
    Thread.sleep(1000);

    //Ürünün sepetten kaldırıldığını doğrulayın
    viewCartPage.setverifyCartDeleteProduct();

    }
    @AfterClass
    public void tearDow(){
        Driver.closeDriver();
    }
}
