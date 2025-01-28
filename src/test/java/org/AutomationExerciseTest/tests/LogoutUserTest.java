package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutUserTest {
    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    ReusableMethods reusableMethods;

    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        loginRegisterPage = new LoginRegisterPage();
    }

    @Test
    public void testLogout() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.loginToYourAccount();
        //efwefd@gmail.com
        loginRegisterPage.loginEmail("efwefd@gmail.com");
        loginRegisterPage.loginPassword("password");
        loginRegisterPage.loginButton();
        tabbarPage.verifyLogin();
        tabbarPage.clickLogout();
        loginRegisterPage.loginToYourAccount();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
