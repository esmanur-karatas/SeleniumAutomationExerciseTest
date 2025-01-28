package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TabbarPage extends Driver {

    public TabbarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a[@href='/login']")
    private WebElement registerLogin;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    protected static WebElement viewHomePage;

    @FindBy(css = "a i.fa-user + b")
    private WebElement verifyLogin;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    public void clickRegisterLogin() {
        registerLogin.click();
    }

    public void verifyLogin() {
        Assert.assertTrue(verifyLogin.isDisplayed());
        System.out.println("Verify Login Success");
    }

    public void clickLogout() {
        logoutButton.click();
    }
}
