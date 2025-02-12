package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.AutomationExerciseTest.pages.ProductPage.driver;

public class LeftSidebarPage {
WebDriver driver;
    public LeftSidebarPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='accordian']//div//div/h4/a")
    private List<WebElement> leftSidebar;

    @FindBy(xpath = "//a[@href='/category_products/1']")
    private WebElement categoryProduct;

    @FindBy(xpath = "//a[@href='/category_products/3']")
    private WebElement categoryManProduct;

    public void setLeftSidebarList(){
        Assert.assertFalse(leftSidebar.isEmpty(), "Arama sonucu boş! Hiç kategori bulunamadı.");
        for (WebElement product : leftSidebar) {
            Assert.assertTrue(product.isDisplayed(), "Kategori görünür değil: " + product.getText());
        }

        System.out.println("Tüm kategoriler başarıyla görüntüleniyor.\nToplam " + leftSidebar.size() + " kategori bulundu.");
        WebElement firstProduct = leftSidebar.get(0);
        firstProduct.click();
    }

    public void setCategoryProduct(){
        categoryProduct.click();
    }

    public void setCategoryManProduct(){
        categoryManProduct.click();
    }

    public void setManCategoryClick(){
        WebElement manCategory = leftSidebar.get(1);
        manCategory.click();
    }
}
