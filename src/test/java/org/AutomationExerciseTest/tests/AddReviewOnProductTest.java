package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.ProductDetailPage;
import org.AutomationExerciseTest.pages.ProductPage;
import org.AutomationExerciseTest.pages.TabbarPage;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AddReviewOnProductTest {
    String url = ConfigurationReader.getProperty("address");
    TabbarPage tabbarPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    @BeforeClass
    public void setUp(){
        //        1. Tarayıcıyı başlatın
        //        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);

        tabbarPage = new TabbarPage();
        productPage = new ProductPage();
        productDetailPage = new ProductDetailPage();
    }

    @Test
    public void testAddReviewOnProduct() throws InterruptedException {

//        3. 'Ürünler' butonuna tıklayın
        tabbarPage.clickProduct();

//        4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        productPage.verifyProductPage("https://automationexercise.com/products");

//        5. 'Ürünü Görüntüle' butonuna tıklayın
        productPage.productView();

//        6. 'İncelemenizi Yazın' seçeneğinin görünür olduğunu doğrulayın
        productDetailPage.setVerifyWriteYourReviewsTextView();

//        7. Adınızı, e-postanızı girin ve yorumunuzu yazın
        productDetailPage.setCommentNameInput("Deneme");
        productDetailPage.setCommentEmailInput("deneme@gmail.com");
        productDetailPage.setCommentMessageInput("Lorem Ipsum");

//        8. 'Gönder' butonuna tıklayın
        productDetailPage.setCommentSubmitButton();
        Thread.sleep(1000);
//        9. 'İncelemeniz için teşekkür ederiz' başarı mesajını doğrulayın.
        productDetailPage.setSuccessTextVerify();
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
