package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.SubscriptionPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubscriptionInCartPageTest {
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    SubscriptionPage subscriptionPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        subscriptionPage = new SubscriptionPage();
    }

    @Test
    public void verifySubscriptionInHomePageTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.basketButtonClick();
        subscriptionPage.verifySubscription();
        subscriptionPage.inputEmail("deneme@gmail.com");
        subscriptionPage.clickSubmit();
        subscriptionPage.verifySuccessSubscribe();

    }
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}

