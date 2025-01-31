package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.AddProductInCartPage;
import org.AutomationExerciseTest.pages.SubscriptionPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.pages.ViewCartPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsInCartTest {
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    SubscriptionPage subscriptionPage;
    AddProductInCartPage addProductInCartPage;
    ViewCartPage viewCartPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        subscriptionPage = new SubscriptionPage();
        viewCartPage = new ViewCartPage();
        addProductInCartPage = new AddProductInCartPage();
    }

    @Test
    public void verifySubscriptionInHomePageTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickProduct();
        addProductInCartPage.clickAddFirstProductToCart();
        addProductInCartPage.clickContinueShoppingButton();
        addProductInCartPage.clickAddSecondProductToCart();
        addProductInCartPage.viewCartClick();
        viewCartPage.ProductsVerify();
        viewCartPage.PriceAndTotalComparisonOfProducts();

    }
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
