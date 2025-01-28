package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserWithIncorrectEmailAndPasswordTest {
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
    public void testLoginUserWithIncorrectEmailAndPassword() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.loginToYourAccount();
        loginRegisterPage.loginEmail("admin@gmail.com");
        loginRegisterPage.loginPassword("admin");
        loginRegisterPage.loginButton();
        loginRegisterPage.errorMessageLogin();

    }
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
