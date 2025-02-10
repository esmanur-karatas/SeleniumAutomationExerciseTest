package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckoutTest extends RegisterUserTest {
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    HomeProductsPage homeProductsPage;
    ViewCartPage viewCartPage;
    LoginRegisterPage loginRegisterPage;
    AccountCreatedPage accountCreatedPage;
    SignUpPage signUpPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    DeleteAccountPage deleteAccountPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeClass
    public void setUp(){
    tabbarPage = new TabbarPage();
    reusableMethods = new ReusableMethods();
    homeProductsPage = new HomeProductsPage();
    viewCartPage = new ViewCartPage();
    loginRegisterPage = new LoginRegisterPage();
    accountCreatedPage = new AccountCreatedPage();
    signUpPage = new SignUpPage();
    checkoutPage = new CheckoutPage();
    paymentPage = new PaymentPage();
    deleteAccountPage = new DeleteAccountPage();
    }

    @Test
    public void testPlaceOrderRegisterWhileCheckout(){
    Driver.getDriver().get(url);
    reusableMethods.verifyHomePage();
    homeProductsPage.clickAddToCart();
    tabbarPage.basketButtonClick();
    viewCartPage.verifyViewCart();
    viewCartPage.clickProceedToCheckoutButton();
    viewCartPage.clickRegisterLoginButton();
    loginRegisterPage.registerName("dascs");
    loginRegisterPage.registerEmail("wjnxdsvdsw@gmail.com");
    loginRegisterPage.registerButton();
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
    tabbarPage.basketButtonClick();
    viewCartPage.clickProceedToCheckoutButton();
    checkoutPage.inputMessage();
    checkoutPage.clickPaymentButton();
    paymentPage.setCartNameInput("sdjkcfn");
    paymentPage.setCartNumberInput("şwaodjx");
    paymentPage.setCvcInput("678");
    paymentPage.setExpiryMonthInput("12");
    paymentPage.setExpiryYearInput("2002");
    paymentPage.setPayButton();
    paymentPage.setOrderPlaced();
    tabbarPage.deleteAccount();
    deleteAccountPage.getVerifyAccountDeleted();
    }

    @AfterClass
    public void tearnDown(){
        Driver.closeDriver();
    }
}
