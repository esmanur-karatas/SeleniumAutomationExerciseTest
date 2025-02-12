package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest {
    String url = ConfigurationReader.getProperty("address");
    LeftSidebarPage leftSidebarPage;
    CategoryProductPage categoryProductPage;
    BrandProductsPage brandProductsPage;
    @BeforeClass
    public void setUp(){
//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(url);
        leftSidebarPage = new LeftSidebarPage();
        categoryProductPage = new CategoryProductPage();
        brandProductsPage = new BrandProductsPage();
    }

    @Test
    public void testViewCategoryProducts() throws InterruptedException {

//        3. Kategorilerin sol taraftaki çubukta görünür olduğunu doğrulayın
//        4. 'Kadınlar' kategorisine tıklayın
        leftSidebarPage.setLeftSidebarList();
//        5. 'Kadın' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        leftSidebarPage.setCategoryProduct();
//        6. Kategori sayfasının görüntülendiğini doğrulayın.
        brandProductsPage.verifyProductsPage("https://automationexercise.com/category_products/1");
//        7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        leftSidebarPage.setManCategoryClick();
        leftSidebarPage.setCategoryManProduct();
//        8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        brandProductsPage.verifyProductsPage("https://automationexercise.com/category_products/3");
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
