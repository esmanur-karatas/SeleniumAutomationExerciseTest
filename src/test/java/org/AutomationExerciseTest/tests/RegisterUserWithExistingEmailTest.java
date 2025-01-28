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

public class RegisterUserWithExistingEmailTest {
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
    public void testRegisterUserWithExistingEmail() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.verifyRegisterPage();
//        efwefd@gmail.com
        loginRegisterPage.registerName("nur");
        loginRegisterPage.registerEmail("efwefd@gmail.com");
        loginRegisterPage.registerButton();
        loginRegisterPage.errorMessageRegister();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
