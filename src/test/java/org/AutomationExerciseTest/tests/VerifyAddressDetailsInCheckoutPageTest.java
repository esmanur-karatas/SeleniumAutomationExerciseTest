package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyAddressDetailsInCheckoutPageTest {

    private static final Logger log = LoggerFactory.getLogger(VerifyAddressDetailsInCheckoutPageTest.class);
    ReusableMethods reusableMethods;
    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;
    HomeProductsPage homeProductsPage;
    ViewCartPage viewCartPage;
    CheckoutPage checkoutPage;
    DeleteAccountPage deleteAccountPage;
    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp(){

        //        1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
        reusableMethods = new ReusableMethods();
        tabbarPage = new TabbarPage();
        loginRegisterPage = new LoginRegisterPage();
        signUpPage = new SignUpPage();
        accountCreatedPage = new AccountCreatedPage();
        homeProductsPage = new HomeProductsPage();
        viewCartPage = new ViewCartPage();
        checkoutPage = new CheckoutPage();
        deleteAccountPage = new DeleteAccountPage();
    }

    @Test
    public void testVerifyAddressDetailsInCheckoutPage() throws InterruptedException {

//        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        reusableMethods.verifyHomePage();

//        4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        tabbarPage.clickRegisterLogin();

//        5. Kayıt için tüm bilgileri doldurun ve hesap oluşturun
        loginRegisterPage.registerName("denertme");
        loginRegisterPage.registerEmail("jfnrefrdrfgtdsf@gmail.com");
        loginRegisterPage.registerButton();
        signUpPage.selectGender();
        signUpPage.setPassword("skfew");
        signUpPage.selectDay();
        signUpPage.selectMonth();
        signUpPage.selectYear();
        signUpPage.clickNewsletter();
        signUpPage.clickOption();
        signUpPage.setFirstName("deneme");
        signUpPage.setLastName("deneme2");
        signUpPage.setAddress("address1");
        signUpPage.setAddress2("address2");
        signUpPage.selectCountry();
        signUpPage.setState("merkez");
        signUpPage.setCity("Elazığ");
        signUpPage.setZipcode("23654");
        signUpPage.setMobileNumber("23456767564");
        signUpPage.createAccount();

//        6. 'HESAP OLUŞTURULDU!' öğesini doğrulayın ve 'Devam' düğmesine tıklayın
        accountCreatedPage.viewAccountCreatedPage();
        accountCreatedPage.ContinueButton();

//        7. Üst taraftaki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        tabbarPage.verifyLogin();

//        8. Ürünleri sepete ekleyin
        homeProductsPage.clickAddToCart();

//        9. 'Sepet' butonuna tıklayın
        homeProductsPage.clickViewProductButton();

//        10. Sepet sayfasının görüntülendiğini doğrulayın
        viewCartPage.verifyViewCart();

//        11. Ödeme İşlemine Devam Et'e tıklayın
        viewCartPage.clickProceedToCheckoutButton();

//        12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        String expectedFullName = "Mrs. deneme deneme2";
        String actualFullName = checkoutPage.getVerifyFirstNameAndLastName();
        Assert.assertEquals(actualFullName, expectedFullName);
        System.out.println("First name and last name do not match!");

        String expectedAddress2 = "address1";
        String actualAddress2 = checkoutPage.getVerifyAddress2();
        Assert.assertEquals(actualAddress2, expectedAddress2);
        System.out.println("Adress2 do not match!");

        String expectedCityAndStateAndPostCode = "Elazığ merkez 23654";
        String actualCityAndStateAndPostCode = checkoutPage.getVerifyCityAndStateAndPostCode();
        Assert.assertEquals(actualCityAndStateAndPostCode, expectedCityAndStateAndPostCode);
        System.out.println("city name, state name and zip code do not match!");

        String expectedCountryName = "India";
        String actualCountryName= checkoutPage.getVerifyCountryName();
        Assert.assertEquals(actualCountryName, expectedCountryName);
        System.out.println("country name do not match!");

        String expectedPhoneNumber= "23456767564";
        String actualPhoneNumber= checkoutPage.getVerifyPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
        System.out.println("phone number do not match!");

//        13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        String expectedFullName2 = "Mrs. deneme deneme2";
        String actualFullName2 = checkoutPage.getVerifyFirstNameAndLastName2();
        Assert.assertEquals(actualFullName2, expectedFullName2);
        System.out.println("First name and last name do not match!");

        String expectedCityAndStateAndPostCode2 = "Elazığ merkez 23654";
        String actualCityAndStateAndPostCode2 = checkoutPage.getVerifyCityAndStateAndPostCode2();
        Assert.assertEquals(actualCityAndStateAndPostCode2, expectedCityAndStateAndPostCode2);
        System.out.println("city name, state name and zip code do not match!");

        String expectedCountryName2 = "India";
        String actualCountryName2= checkoutPage.getVerifyCountryName2();
        Assert.assertEquals(actualCountryName2, expectedCountryName2);
        System.out.println("country name do not match!");

        String expectedPhoneNumber2= "23456767564";
        String actualPhoneNumber2= checkoutPage.getVerifyPhoneNumber2();
        Assert.assertEquals(actualPhoneNumber2, expectedPhoneNumber2);
        System.out.println("phone number do not match!");

//        14. 'Hesabı Sil' butonuna tıklayın
        tabbarPage.deleteAccount();
//        15. 'HESAP SİLİNDİ!'yi doğrulayın ve 'Devam' düğmesine tıklayın
        deleteAccountPage.getVerifyAccountDeleted();
        Thread.sleep(3000);
        deleteAccountPage.setContinueButton();
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
