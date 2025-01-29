package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubscriptionPage {

    public SubscriptionPage() {
    PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id ="susbscribe_email" )
    private WebElement inputEmail;

    @FindBy(id = "subscribe")
    private WebElement submitButton;

    @FindBy(id = "success-subscribe")
    private WebElement successSubscribe;

    public void verifySubscription() {
        Assert.assertTrue(subscriptionText.isDisplayed());
    }

    public void inputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void clickSubmit() {
        submitButton.click();
    }
    public void verifySuccessSubscribe() {
        Assert.assertTrue(successSubscribe.isDisplayed());
        System.out.println("Success subscribe");
    }

}
