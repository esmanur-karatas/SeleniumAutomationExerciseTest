package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCartTest {
    ReusableMethods reusableMethods;
    HomeProductsPage homeProductsPage;
    ProductDetailPage productDetailPage;
    AddProductInCartPage addProductInCartPage;
    TabbarPage tabbarPage;
    ViewCartPage viewCartPage;
    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp()
    {
        reusableMethods = new ReusableMethods();
        homeProductsPage = new HomeProductsPage();
        productDetailPage = new ProductDetailPage();
        addProductInCartPage = new AddProductInCartPage();
        viewCartPage = new ViewCartPage();
        tabbarPage = new TabbarPage();
    }

    @Test
    public void testVerifyProductQuantityInCart() throws InterruptedException {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        homeProductsPage.clickViewProductButton();
        productDetailPage.verifyProductName();
        productDetailPage.productQuantityCount();
        productDetailPage.clickAddToBasket();
        addProductInCartPage.viewCartClick();
        tabbarPage.basketButtonClick();
        viewCartPage.setVerifyQuantity();
    }

    @AfterClass
    public void TearnDown(){
        Driver.closeDriver();
    }
}
