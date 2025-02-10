package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.CommandLineArgs;

import java.util.List;


public class ProductPage {
    static WebDriver driver;
    public ProductPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement productView;

    @FindBy(id = "search_product")
    private WebElement searchField;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    private WebElement searchButton;

    @FindBy(className = "product-image-wrapper")
    private List<WebElement> featuresItems;

    public void verifyProductPage(String expectedText) {
        String actualText = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("Product page verified");
    }

    public void pageScrollDown(){
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", productView);
    }

    public void productView() {
        productView.click();
    }
    public void searchField(String searchText) {
        searchField.sendKeys(searchText);
        searchButton.click();
    }

    public void verifyFeaturesItems() {
        Assert.assertFalse(featuresItems.isEmpty(), "Arama sonucu boş! Hiç ürün bulunamadı.");
        for (WebElement product : featuresItems) {
            Assert.assertTrue(product.isDisplayed(), "Ürün görünür değil: " + product.getText());
        }

        System.out.println("Tüm ürünler başarıyla görüntüleniyor.\nToplam " + featuresItems.size() + " ürün bulundu.");
    }
}
