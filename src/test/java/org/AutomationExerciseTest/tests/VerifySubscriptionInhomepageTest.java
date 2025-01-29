package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.SubscriptionPage;
import org.AutomationExerciseTest.pages.ProductDetailPage;
import org.AutomationExerciseTest.pages.ProductPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubscriptionInhomepageTest {
    static WebDriver driver;
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    JavascriptExecutor js;
    SubscriptionPage subscriptionPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        js = (JavascriptExecutor) driver;
        subscriptionPage = new SubscriptionPage();
    }
    @Test
    public void verifySubscriptionInHomePageTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        subscriptionPage.verifySubscription();
        subscriptionPage.inputEmail("esoes@gmail.com");
        subscriptionPage.clickSubmit();
        subscriptionPage.verifySuccessSubscribe();
    }
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
