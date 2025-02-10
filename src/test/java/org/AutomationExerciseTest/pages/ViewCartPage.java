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

    @FindBy(className = "disabled")
    private WebElement verifyQuantity;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement ProceedToCheckoutButton;

    @FindBy(xpath = "(//a[@href='/login'])[2]")
    private WebElement registerLoginButton;

    @FindBy(className = "cart_quantity_delete")
    private WebElement cartQuantityDelete;

    @FindBy(xpath = "//b[text()='Cart is empty!']")
    private WebElement verifyCartDeleteProduct;

    public void ProductsVerify(){
        Assert.assertTrue(firstProductVerify.isDisplayed());
        Assert.assertTrue(secondProductVerify.isDisplayed());
        System.out.println("Ürünler başarılı bir şekilde sepete eklendi");
    }

    public void verifyViewCart(){
        Assert.assertTrue(firstProductVerify.isDisplayed());
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

    public void setVerifyQuantity(){
        String actualText = verifyQuantity.getText();
        String expectedText = "4";
        if(expectedText.equals(actualText)){
            System.out.println("Miktar doğrulama başarılı");
        }else {
            System.out.println("Miktar Doğrulama Başarısız");
        }
    }

    public void clickProceedToCheckoutButton(){
        ProceedToCheckoutButton.click();
    }

    public void clickRegisterLoginButton(){
        registerLoginButton.click();
    }

    public void setClickCartQuantityDelete(){
        cartQuantityDelete.click();
    }

    public void setverifyCartDeleteProduct()
    {
        String actualText = "Cart is empty!";
        String expectedText = verifyCartDeleteProduct.getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Ürün başarılı bir şekilde silindi!");
    }
}
