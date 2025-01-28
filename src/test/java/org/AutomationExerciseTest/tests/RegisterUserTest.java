package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {

    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    ReusableMethods reusableMethods;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        loginRegisterPage = new LoginRegisterPage();
        signUpPage = new SignUpPage();
        accountCreatedPage = new AccountCreatedPage();
        deleteAccountPage = new DeleteAccountPage();
    }

    @Test
    public void RegisterUserTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.verifyRegisterPage();
        loginRegisterPage.registerName("Esmanur");
        loginRegisterPage.registerEmail("regvergvw@gmail.com");
        loginRegisterPage.registerButton();
        signUpPage.verifySignUpFormText();
        signUpPage.selectGender();
        signUpPage.setPassword("esmanur");
        signUpPage.selectDay();
        signUpPage.selectMonth();
        signUpPage.selectYear();
        signUpPage.clickNewsletter();
        signUpPage.clickOption();
        signUpPage.setFirstName("Esmanur");
        signUpPage.setLastName("deneme");
        signUpPage.setCompany("deneme");
        signUpPage.setAddress("esmanur");
        signUpPage.setAddress2("denemefreg");
        signUpPage.selectCountry();
        signUpPage.setState("Elazığ");
        signUpPage.setCity("Merkez");
        signUpPage.setZipcode("32425");
        signUpPage.setMobileNumber("489357349587");
        signUpPage.createAccount();
        accountCreatedPage.viewAccountCreatedPage();
        accountCreatedPage.ContinueButton();
        tabbarPage.verifyLogin();
        deleteAccountPage.deleteAccount();
        deleteAccountPage.getVerifyAccountDeleted();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}