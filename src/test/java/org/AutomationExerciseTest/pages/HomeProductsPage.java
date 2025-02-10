package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeProductsPage {

    public HomeProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductButton;

    @FindBy(xpath ="//a[@data-product-id=\"1\"]" )
    private WebElement productAddToCart;

    public void clickViewProductButton(){
        viewProductButton.click();
    }

    public void clickAddToCart(){
        productAddToCart.click();
    }
}
