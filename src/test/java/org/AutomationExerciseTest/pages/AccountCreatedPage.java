package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountCreatedPage {
    public AccountCreatedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement viewAccountCreatedPage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public void viewAccountCreatedPage() {
        Assert.assertTrue(viewAccountCreatedPage.isDisplayed());
    }
    public void ContinueButton() {
        continueButton.click();
    }

}
