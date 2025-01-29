package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.ProductDetailPage;
import org.AutomationExerciseTest.pages.ProductPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest {
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
    public void searchProduct() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickProduct();
        productPage.verifyProductPage("https://automationexercise.com/products");
        productPage.searchField("Dress");
        productPage.verifyFeaturesItems();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
