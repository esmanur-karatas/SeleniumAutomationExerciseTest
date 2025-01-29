package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailPageTest {
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        productPage = new ProductPage();
        productDetailPage = new ProductDetailPage();
    }

    @Test
    public void verifyAllProductsAndProductDetailPage() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickProduct();
        productPage.verifyProductPage("https://automationexercise.com/products");
        productPage.pageScrollDown();
        productPage.productView();
        productDetailPage.verifyProductName();
        productDetailPage.verifyProductCategory();
        productDetailPage.verifyProductPrice();
        productDetailPage.verifyProductAvailability();
        productDetailPage.verifyPrductCondition();
        productDetailPage.verifyProductBrand();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
