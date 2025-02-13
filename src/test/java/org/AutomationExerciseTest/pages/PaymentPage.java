package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name=\"name_on_card\"]")
    private WebElement cartNameInput;

    @FindBy(name = "card_number")
    private WebElement cartNumberInput;

    @FindBy(name = "cvc")
    private WebElement cvcInput;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInput;

    @FindBy(name = "expiry_year")
    private WebElement expiryYearInput;

    @FindBy(xpath = "//button[@data-qa=\"pay-button\"]")
    private WebElement payButton;

    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    private WebElement orderPlaced;

    @FindBy(xpath = "//a[@href='/download_invoice/500']")
    private WebElement downloadInvoice;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public void setCartNameInput(String cartName){
        cartNameInput.sendKeys(cartName);
    }

    public void setCartNumberInput(String cartNumber){
        cartNumberInput.sendKeys(cartNumber);
    }

    public void setCvcInput(int cvc){
        cartNumberInput.sendKeys(String.valueOf(cvc));
    }

    public void setExpiryMonthInput(int expiryMonth){
        cartNumberInput.sendKeys(String.valueOf(expiryMonth));
    }

    public void setExpiryYearInput(int expiryYear){
        cartNumberInput.sendKeys(String.valueOf(expiryYear));
    }

    public void setPayButton(){
        payButton.click();
    }

    public void setOrderPlaced(){
        Assert.assertTrue(orderPlaced.isDisplayed());
        System.out.println("Siparişiniz Alındı");
    }
    public void setClickDownloadInvoice(){
        downloadInvoice.click();
    }

    public void setClickContinueButton() {
        continueButton.click();
    }
}
