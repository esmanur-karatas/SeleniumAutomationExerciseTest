package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.plaf.PanelUI;

public class LoginRegisterPage {
    public LoginRegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='signup-form']//h2")
    private WebElement viewRegisterPage;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement registerName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement registerEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement registerButton;

    @FindBy(className = "login-form")
    private WebElement loginToYourAccount;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]\n")
    private WebElement errorMessageLogin;

    @FindBy(xpath = "//p[contains(text(), 'Email Address already exist!')]")
    private WebElement errorMessageRegister;

    public void verifyRegisterPage() {
        Assert.assertTrue(viewRegisterPage.isDisplayed());
        System.out.println("View register page is displayed");
    }

    public void registerName(String name) {
        registerName.sendKeys(name);
    }

    public void registerEmail(String email) {
        registerEmail.sendKeys(email);
    }
    public void registerButton() {
        registerButton.click();
    }
  public void loginToYourAccount() {
        Assert.assertTrue(loginToYourAccount.isDisplayed());
  }

  public void loginEmail(String email) {
        loginEmail.sendKeys(email);
  }

  public void loginPassword(String password) {
        loginPassword.sendKeys(password);
  }

  public void loginButton() {
        loginButton.click();
  }
  public void errorMessageLogin() {
        Assert.assertTrue(errorMessageLogin.isDisplayed());
        String errorMessage= errorMessageLogin.getText();
        System.out.println("hata mesajı: "+errorMessage);
  }

  public void errorMessageRegister() {
        Assert.assertTrue(errorMessageRegister.isDisplayed());
        String errorMessage= errorMessageRegister.getText();
        System.out.println("Hata Message: "+errorMessage);
  }
}
