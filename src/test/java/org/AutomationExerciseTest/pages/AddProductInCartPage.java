package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductInCartPage {
    WebDriver driver;
    Actions actions;

    public AddProductInCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    private WebElement addFirstProductToCart;

    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    private WebElement addSecondProductToCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    private WebElement viewCart;


    public void clickAddFirstProductToCart(){
        addFirstProductToCart.click();
    }

    public void clickAddSecondProductToCart(){
        addSecondProductToCart.click();
    }

    public void clickContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void viewCartClick(){
        viewCart.click();
    }
}
