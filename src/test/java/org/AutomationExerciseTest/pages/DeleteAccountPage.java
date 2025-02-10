package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteAccountPage {

    public DeleteAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h2.title.text-center[data-qa='account-deleted']\n")
    private WebElement verifyAccountDeleted;

    @FindBy(css = "li a[href='/delete_account']")
    private WebElement deleteAccount;

    @FindBy(xpath = " //a[@data-qa='continue-button']")
    private WebElement continueButton;

    public void getVerifyAccountDeleted() {
        Assert.assertTrue(verifyAccountDeleted.isDisplayed());

    }

    public void deleteAccount() {
        deleteAccount.click();
    }

    public void setContinueButton()
    {
        continueButton.click();
    }
}

