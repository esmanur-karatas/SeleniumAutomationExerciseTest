package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserWithCorrectEmailAndPasswordTest {
    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    ReusableMethods reusableMethods;
    DeleteAccountPage deleteAccountPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        loginRegisterPage = new LoginRegisterPage();
        deleteAccountPage = new DeleteAccountPage();
    }

    @Test
    public void LoginUserWithCorrectEmailAndPasswordTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.loginToYourAccount();
        //test3223@gmail.com
        loginRegisterPage.loginEmail("test3223@gmail.com");
        //drgdfrg
        loginRegisterPage.loginPassword("drgdfrg");
        loginRegisterPage.loginButton();
        tabbarPage.verifyLogin();
        deleteAccountPage.deleteAccount();
        deleteAccountPage.getVerifyAccountDeleted();
        Driver.closeDriver();
    }
}
