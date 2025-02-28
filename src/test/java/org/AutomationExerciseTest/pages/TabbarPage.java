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

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "(//a[@href='/'])[1]")
    private WebElement homeButton;

    @FindBy(xpath = "(//a[@href='/test_cases'])[1]")
    private WebElement testCasesButton;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productButton;

    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    private WebElement basketButton;

    @FindBy(css = "li a[href='/delete_account']")
    private WebElement deleteAccount;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

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

    public void clickContactUs() {
        contactUsButton.click();
    }
    public void clickHome() {
        homeButton.click();
    }

    public void clickTestCases() {
        testCasesButton.click();
    }
    public void clickProduct() {
        productButton.click();
    }
    public void basketButtonClick(){
        basketButton.click();
    }

    public void deleteAccount() {
        deleteAccount.click();
    }

    public void setClickCartButton(){
        cartButton.click();
    }
}
