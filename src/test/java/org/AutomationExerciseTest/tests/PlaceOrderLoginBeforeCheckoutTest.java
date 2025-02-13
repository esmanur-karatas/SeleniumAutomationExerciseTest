package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlaceOrderLoginBeforeCheckoutTest {
    String url = ConfigurationReader.getProperty("address");
    ReusableMethods reusableMethods;
    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    HomeProductsPage homeProductsPage;
    ViewCartPage viewCartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    DeleteAccountPage deleteAccountPage;
    @BeforeClass
    public void setUp(){
//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
        reusableMethods = new ReusableMethods();
        tabbarPage = new TabbarPage();
        loginRegisterPage = new LoginRegisterPage();
        homeProductsPage = new HomeProductsPage();
        viewCartPage = new ViewCartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        deleteAccountPage = new DeleteAccountPage();
    }

    @Test
    public void testPlaceOrderLoginBeforeCheckout(){

//        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        reusableMethods.verifyHomePage();
//        4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        tabbarPage.clickRegisterLogin();
//        5. E-postanızı ve şifrenizi girin ve 'Giriş' butonuna tıklayın.
        loginRegisterPage.loginEmail("Deneme@gmal.com");
        loginRegisterPage.loginPassword("deneme123");
        loginRegisterPage.loginButton();
//        6. Üst taraftaki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        tabbarPage.verifyLogin();
//        7. Ürünleri sepete ekleyin
        homeProductsPage.clickAddToCart();
//        8. 'Sepet' butonuna tıklayın
        homeProductsPage.clickViewProductButton();
        tabbarPage.setClickCartButton();
//        9. Sepet sayfasının görüntülendiğini doğrulayın
        viewCartPage.verifyViewCart();
//        10. Ödeme İşlemine Devam Et'e tıklayın
        viewCartPage.clickProceedToCheckoutButton();
//        11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi Gözden Geçirin
        String expectedFullName = ". rf we";
        String actualFullName = checkoutPage.getVerifyFirstNameAndLastName();
        Assert.assertEquals(actualFullName, expectedFullName);
        System.out.println("First name and last name do not match!");

        String expectedAddress2 = "we";
        String actualAddress2 = checkoutPage.getVerifyAddress2();
        Assert.assertEquals(actualAddress2, expectedAddress2);
        System.out.println("Adress2 do not match!");

        String expectedCityAndStateAndPostCode = "we we 121";
        String actualCityAndStateAndPostCode = checkoutPage.getVerifyCityAndStateAndPostCode();
        Assert.assertEquals(actualCityAndStateAndPostCode, expectedCityAndStateAndPostCode);
        System.out.println("city name, state name and zip code do not match!");

        String expectedCountryName = "United States";
        String actualCountryName= checkoutPage.getVerifyCountryName();
        Assert.assertEquals(actualCountryName, expectedCountryName);
        System.out.println("country name do not match!");

        String expectedPhoneNumber= "213";
        String actualPhoneNumber= checkoutPage.getVerifyPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
        System.out.println("phone number do not match!");

//        12. Açıklamayı yorum metin alanına girin ve 'Sipariş Ver'e tıklayın.
        checkoutPage.inputMessage();
        checkoutPage.clickPaymentButton();
//        13. Ödeme ayrıntılarını girin: Karttaki İsim, Kart Numarası, CVC, Son Kullanma Tarihi
        paymentPage.setCartNameInput("deneme");
        paymentPage.setCartNumberInput("12345345");
        paymentPage.setCvcInput(123);
        paymentPage.setExpiryMonthInput(12);
        paymentPage.setExpiryYearInput(2002);
//        14. 'Öde ve Siparişi Onayla' butonuna tıklayın
        paymentPage.setPayButton();
//        15. 'Siparişiniz başarıyla iletildi!' başarı mesajını doğrulayın.
        paymentPage.setOrderPlaced();
//        16. 'Hesabı Sil' butonuna tıklayın
        tabbarPage.deleteAccount();
//        17. 'HESAP SİLİNDİ!'yi doğrulayın ve 'Devam' düğmesine tıklayın
        deleteAccountPage.getVerifyAccountDeleted();
        deleteAccountPage.setContinueButton();
    }

    @AfterClass
    public void tearDown(){
       // Driver.closeDriver();
    }
}
