package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLoginTest {
    TabbarPage tabbarPage;
    ProductPage productPage;
    HomePage homePage;
    LoginRegisterPage loginRegisterPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeClass
    public void setUp(){
        tabbarPage = new TabbarPage();
        productPage = new ProductPage();
        homePage = new HomePage();
        loginRegisterPage = new LoginRegisterPage();
        //        1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
    }

    @Test
    public void testSearchProductsAndVerifyCartAfterLogin() throws InterruptedException {

//        3. 'Ürünler' butonuna tıklayın
        tabbarPage.clickProduct();

//        4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        productPage.verifyProductPage("https://automationexercise.com/products");

//        5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
        productPage.searchField("Dress");

//        6. 'ARADIĞINIZ ÜRÜNLER'in görünür olduğunu doğrulayı
//        7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        productPage.verifyFeaturesItems();

//        8. Bu ürünleri sepete ekleyin
        productPage.addAllProductsToCart();

//        9. 'Sepet' butonuna tıklayın.
        homePage.setViewCartButtonClick();

//        10. 'Kayıt Ol / Giriş Yap' butonuna tıklayın ve giriş bilgilerinizi gönderin.
        tabbarPage.clickRegisterLogin();
        loginRegisterPage.loginEmail("Deneme@gmal.com");
        loginRegisterPage.loginPassword("deneme123");
        loginRegisterPage.loginButton();

//        11. Tekrar Sepet sayfasına gidin
        tabbarPage.setClickCartButton();
//        12. Giriş yaptıktan sonra bu ürünlerin sepette de göründüğünü doğrulayın.

    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
