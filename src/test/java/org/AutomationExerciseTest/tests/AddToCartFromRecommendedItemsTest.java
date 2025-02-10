package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.HomePage;
import org.AutomationExerciseTest.pages.ViewCartPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItemsTest {
    ReusableMethods reusableMethods;
    HomePage homePage;
    ViewCartPage viewCartPage;
    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp(){
        reusableMethods = new ReusableMethods();
        homePage = new HomePage();
        viewCartPage = new ViewCartPage();
        Driver.getDriver().get(url);
    }

    @Test
    public void testAddToCartFromRecommededItemsTest(){
        reusableMethods.verifyHomePage();
        homePage.scrollHomePageDown();
        homePage.setRecommendedItemCarousel();
        homePage.setAddToCart();
        homePage.setViewCartButtonClick();
        viewCartPage.verifyViewCart();

    }

    @AfterClass
    public void tearnDown(){
        Driver.closeDriver();
    }
}
