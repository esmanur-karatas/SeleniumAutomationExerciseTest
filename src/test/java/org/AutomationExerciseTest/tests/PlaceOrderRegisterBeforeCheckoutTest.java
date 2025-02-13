package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlaceOrderRegisterBeforeCheckoutTest {
    String url = ConfigurationReader.getProperty("address");
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    LoginRegisterPage loginRegisterPage;
    SignUpPage signUpPage;
    HomeProductsPage homeProductsPage;
    ViewCartPage viewCartPage;
    CheckoutPage checkoutPage;
    DeleteAccountPage deleteAccountPage;
    PaymentPage paymentPage;
    @BeforeClass
    public void setUp(){
//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        loginRegisterPage = new LoginRegisterPage();
        signUpPage = new SignUpPage();
        homeProductsPage = new HomeProductsPage();
        viewCartPage = new ViewCartPage();
        checkoutPage = new CheckoutPage();
        deleteAccountPage = new DeleteAccountPage();
        paymentPage = new PaymentPage();
    }

    @Test
    public void testPlaceOrderRegisterBeforeCheckout(){

//        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        reusableMethods.verifyHomePage();
//        4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        tabbarPage.clickRegisterLogin();
//        5. Kayıt için tüm bilgileri doldurun ve hesap oluşturun

//        6. 'HESAP OLUŞTURULDU!' öğesini doğrulayın ve 'Devam' düğmesine tıklayın
        loginRegisterPage.registerName("deneme");
        loginRegisterPage.registerEmail("dene@gmail.com");
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
//        7. Üst taraftaki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        tabbarPage.verifyLogin();
//        8. Ürünleri sepete ekleyin
        homeProductsPage.clickAddToCart();
//        9. 'Sepet' butonuna tıklayın
        homeProductsPage.clickViewProductButton();
        tabbarPage.setClickCartButton();
//        10. Sepet sayfasının görüntülendiğini doğrulayın
        viewCartPage.verifyViewCart();
//        11. Ödeme İşlemine Devam Et'e tıklayın
        viewCartPage.clickProceedToCheckoutButton();
//        12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi Gözden Geçirin
        String expectedFullName = "Mrs. Esmanur deneme";
        String actualFullName = checkoutPage.getVerifyFirstNameAndLastName();
        Assert.assertEquals(actualFullName, expectedFullName);
        System.out.println("First name and last name do not match!");

        String expectedCityAndStateAndPostCode = "Merkez Elazığ 32425";
        String actualCityAndStateAndPostCode = checkoutPage.getVerifyCityAndStateAndPostCode();
        Assert.assertEquals(actualCityAndStateAndPostCode, expectedCityAndStateAndPostCode);
        System.out.println("city name, state name and zip code do not match!");

        String expectedCountryName = "India";
        String actualCountryName= checkoutPage.getVerifyCountryName();
        Assert.assertEquals(actualCountryName, expectedCountryName);
        System.out.println("country name do not match!");

        String expectedPhoneNumber= "489357349587";
        String actualPhoneNumber= checkoutPage.getVerifyPhoneNumber();
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
        System.out.println("phone number do not match!");
//        13. Açıklamayı yorum metin alanına girin ve 'Sipariş Ver'e tıklayın.
        checkoutPage.inputMessage();
        checkoutPage.clickPaymentButton();
//        14. Ödeme ayrıntılarını girin: Karttaki İsim, Kart Numarası, CVC, Son Kullanma Tarihi
        paymentPage.setCartNameInput("deneme");
        paymentPage.setCartNumberInput("12345345");
        paymentPage.setCvcInput(123);
        paymentPage.setExpiryMonthInput(12);
        paymentPage.setExpiryYearInput(2002);
//        15. 'Öde ve Siparişi Onayla' butonuna tıklayın
        paymentPage.setPayButton();
//        16. 'Siparişiniz başarıyla iletildi!' başarı mesajını doğrulayın.
        paymentPage.setOrderPlaced();
//        17. 'Hesabı Sil' butonuna tıklayın
        tabbarPage.deleteAccount();
//        18. 'HESAP SİLİNDİ!'yi doğrulayın ve 'Devam' düğmesine tıklayın
        deleteAccountPage.getVerifyAccountDeleted();
        deleteAccountPage.setContinueButton();
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
