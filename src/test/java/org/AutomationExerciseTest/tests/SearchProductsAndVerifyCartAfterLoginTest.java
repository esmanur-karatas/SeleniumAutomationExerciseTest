package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.ProductPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLoginTest {
    TabbarPage tabbarPage;
    ProductPage productPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeClass
    public void setUp(){
        tabbarPage = new TabbarPage();
        productPage = new ProductPage();
        //        1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
    }

    @Test
    public void testSearchProductsAndVerifyCartAfterLogin(){

//        3. 'Ürünler' butonuna tıklayın
        tabbarPage.clickProduct();

//        4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        productPage.verifyProductPage("https://automationexercise.com/products");

//        5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
        productPage.searchField("Dress");

//        6. 'ARADIĞINIZ ÜRÜNLER'in görünür olduğunu doğrulayın
        productPage.verifyFeaturesItems();

//        7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın

//        8. Bu ürünleri sepete ekleyin

//        9. 'Sepet' butonuna tıklayın ve ürünlerin sepette göründüğünü doğrulayın.

//        10. 'Kayıt Ol / Giriş Yap' butonuna tıklayın ve giriş bilgilerinizi gönderin.

//        11. Tekrar Sepet sayfasına gidin

//        12. Giriş yaptıktan sonra bu ürünlerin sepette de göründüğünü doğrulayın.
    }


    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
