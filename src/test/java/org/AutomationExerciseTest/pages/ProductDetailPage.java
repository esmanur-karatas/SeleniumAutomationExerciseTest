package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class ProductDetailPage {
    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Blue Top']")
    private WebElement productName;

    @FindBy(xpath = "//p[text()='Category: Women > Tops']")
    private WebElement productCategory;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    private WebElement productPrice;

    @FindBy(xpath = "//p[text()=' In Stock']")
    private WebElement producyAvailability;

    @FindBy(xpath = "//p[text()=' New']")
    private WebElement prductCondition;

    @FindBy(xpath = "//p[text()=' Polo']")
    private WebElement productBrand;

    @FindBy(id = "quantity")
    private WebElement productQuantityCount;

    @FindBy(xpath = "(//button//i)[1]")
    private WebElement addToBasket;

    public void verifyProductName() {
        Assert.assertTrue(productName.isDisplayed());
        System.out.println("Product Name: " + productName.getText());
    }
    public void verifyProductCategory() {
        Assert.assertTrue(productCategory.isDisplayed());
        System.out.println("Product Category: " + productCategory.getText());
    }
    public void verifyProductPrice() {
        Assert.assertTrue(productPrice.isDisplayed());
        System.out.println("Product Price: " + productPrice.getText());
    }
    public void verifyProductAvailability() {
        Assert.assertTrue(producyAvailability.isDisplayed());
        System.out.println("Product Availability: " + producyAvailability.getText());
    }
    public void verifyPrductCondition() {
        Assert.assertTrue(prductCondition.isDisplayed());
        System.out.println("Product Condition: " + prductCondition.getText());
    }
    public void verifyProductBrand() {
        Assert.assertTrue(productBrand.isDisplayed());
        System.out.println("Product Brand: " + productBrand.getText());
    }
    public void productQuantityCount() throws InterruptedException {
        productQuantityCount.clear();
        productQuantityCount.sendKeys("4", Keys.TAB);
        Thread.sleep(3000);
    }
    public void clickAddToBasket(){
        addToBasket.click();
    }

}
