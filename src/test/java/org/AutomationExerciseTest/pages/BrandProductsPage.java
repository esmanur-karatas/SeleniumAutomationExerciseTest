package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BrandProductsPage {
    WebDriver driver;

    public BrandProductsPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void verifyProductsPage(String expectedUrl) {
        Assert.assertNotNull(driver, "Driver null! Sayfa doğrulama yapılamadı.");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Sayfa URL'si beklenenle eşleşmiyor!");
        System.out.println("Sayfanın URL'si doğrulandı: " + currentUrl);
    }
}
