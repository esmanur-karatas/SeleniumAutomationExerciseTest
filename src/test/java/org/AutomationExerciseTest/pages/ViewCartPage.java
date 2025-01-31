package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViewCartPage {
    public ViewCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstProductVerify;

    @FindBy(xpath="//a[@href='/product_details/2']")
    private WebElement secondProductVerify;

    @FindBy(xpath = "(//td[@class='cart_price'])[1]")
    private WebElement firstProductPrice;

    @FindBy(xpath = "(//td[@class='cart_price'])[2]")
    private WebElement secondProductPrice;

    @FindBy(xpath = "(//p[@class='cart_total_price'])[1]")
    private WebElement firstProductTotal;

    @FindBy(xpath = "(//p[@class='cart_total_price'])[2]")
    private WebElement secondProductTotal;

    public void ProductsVerify(){
        Assert.assertTrue(firstProductVerify.isDisplayed());
        Assert.assertTrue(secondProductVerify.isDisplayed());
        System.out.println("Ürünler başarılı bir şekilde sepete eklendi");
    }

    public void PriceAndTotalComparisonOfProducts(){
        String product1Price = firstProductPrice.getText();
        String product1Total = firstProductTotal.getText();
        Assert.assertEquals(product1Price, product1Total);

        String product2Price = secondProductPrice.getText();
        String product2Total = secondProductTotal.getText();
        Assert.assertEquals(product2Price, product2Total);

        System.out.println("Doğrulama başarılı");
    }

}
