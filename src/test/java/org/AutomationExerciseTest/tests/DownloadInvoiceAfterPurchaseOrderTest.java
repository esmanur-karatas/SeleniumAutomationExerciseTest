package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadInvoiceAfterPurchaseOrderTest {

    ReusableMethods reusableMethods;
    HomeProductsPage homeProductsPage;
    HomePage homePage;
    ViewCartPage viewCartPage;
    LoginRegisterPage loginRegisterPage;
    SignUpPage signUpPage;
    TabbarPage tabbarPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    DeleteAccountPage deleteAccountPage;
    AccountCreatedPage accountCreatedPage;
    String url = ConfigurationReader.getProperty("address");
    @BeforeClass
    public void setUp(){
        reusableMethods = new ReusableMethods();
        homeProductsPage = new HomeProductsPage();
        homePage = new HomePage();
        viewCartPage = new ViewCartPage();
        loginRegisterPage = new LoginRegisterPage();
        signUpPage = new SignUpPage();
        tabbarPage = new TabbarPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        deleteAccountPage = new DeleteAccountPage();
        accountCreatedPage = new AccountCreatedPage();
        //Tarayıcı Başlatın
        //'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
    }
    @Test
    public void testDownloadInvoiceAfterPuechaseOrderText() throws InterruptedException {

//        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        reusableMethods.verifyHomePage();

//        4. Ürünleri sepete ekleyin
        homeProductsPage.clickAddToCart();

//        5. 'Sepet' butonuna tıklayın
        homePage.setViewCartButtonClick();

//        6. Sepet sayfasının görüntülendiğini doğrulayın
        viewCartPage.verifyViewCart();

//        7. Ödeme İşlemine Devam Et'e tıklayın
        viewCartPage.clickProceedToCheckoutButton();

//        8. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        viewCartPage.clickRegisterLoginButton();

//        9. Kayıt ol kısmındaki tüm bilgileri doldurun ve hesap oluşturun
        loginRegisterPage.registerName("denertme");
        loginRegisterPage.registerEmail("jfnrefrtdsf@gmail.com");
        loginRegisterPage.registerButton();

//        10. 'HESAP OLUŞTURULDU!' öğesini doğrulayın ve 'Devam' düğmesine tıklayın
        signUpPage.selectGender();
        signUpPage.setPassword("skfew");
        signUpPage.selectDay();
        signUpPage.selectMonth();
        signUpPage.selectYear();
        signUpPage.clickNewsletter();
        signUpPage.clickOption();
        signUpPage.setFirstName("deneme");
        signUpPage.setLastName("deneme2");
        signUpPage.setAddress("rıkjfreıojf");
        signUpPage.setAddress2("eıjfcıoewfjpwe");
        signUpPage.selectCountry();
        signUpPage.setState("sfsf");
        signUpPage.setCity("Elazığ");
        signUpPage.setZipcode("23654");
        signUpPage.setMobileNumber("23456767564");
        signUpPage.createAccount();

//        11. Üst taraftaki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        accountCreatedPage.ContinueButton();
        tabbarPage.verifyLogin();

//        12.'Sepet' butonuna tıklayın
        tabbarPage.setClickCartButton();

//        13. 'Ödeme İşlemine Devam Et' butonuna tıklayın
        viewCartPage.clickProceedToCheckoutButton();

//        14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi Gözden Geçirin
//        15. Açıklamayı yorum metin alanına girin ve 'Sipariş Ver'e tıklayın.
        checkoutPage.inputMessage();
        checkoutPage.clickPaymentButton();

//        16. Ödeme ayrıntılarını girin: Karttaki İsim, Kart Numarası, CVC, Son Kullanma Tarihi
        paymentPage.setCartNameInput("deneme");
        paymentPage.setCartNumberInput("456323232");
        paymentPage.setCvcInput(String.valueOf(Integer.parseInt("544")));
        paymentPage.setExpiryMonthInput(String.valueOf(Integer.parseInt("12")));
        paymentPage.setExpiryYearInput(String.valueOf(Integer.parseInt("2020")));


//        17. 'Öde ve Siparişi Onayla' butonuna tıklayın
        paymentPage.setPayButton();

//        18. 'Siparişiniz başarıyla iletildi!' başarı mesajını doğrulayın.
        paymentPage.setOrderPlaced();

//        19. 'Faturayı İndir' butonuna tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        paymentPage.setClickDownloadInvoice();

//        20. 'Devam' butonuna tıklayın
        paymentPage.setClickContinueButton();

//        21. 'Hesabı Sil' butonuna tıklayın
        tabbarPage.deleteAccount();

//        22. 'HESAP SİLİNDİ!'yi doğrulayın ve 'Devam' düğmesine tıklayın
        deleteAccountPage.getVerifyAccountDeleted();
        Thread.sleep(3000);
        deleteAccountPage.setContinueButton();
    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
