package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.HomePage;
import org.AutomationExerciseTest.pages.SubscriptionPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityTest {

    ReusableMethods reusableMethods;
    HomePage homePage;
    SubscriptionPage subscriptionPage;

    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp(){
        reusableMethods = new ReusableMethods();
        homePage = new HomePage();
        subscriptionPage = new SubscriptionPage();
        Driver.getDriver().get(url);
    }

    @Test
    public void testVerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality(){
        reusableMethods.verifyHomePage();
        homePage.scrollHomePageDown();
        subscriptionPage.verifySubscription();
        homePage.scrollHomePageUp();
        homePage.setVerifySliderText();
    }

    @AfterClass
    public void tearnDown(){
        Driver.closeDriver();
    }
}
