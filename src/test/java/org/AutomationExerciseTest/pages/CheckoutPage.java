package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage extends SignUpPage{
    SignUpPage signUpPage = new SignUpPage();
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "message")
    private WebElement message;

    @FindBy(xpath = "//a[@href=\"/payment\"]")
    private WebElement paymentButton;

    @FindBy(xpath = "(//li[contains(@class, 'address_firstname') and contains(@class, 'address_lastname')])[1]")
    private WebElement verifyFirstNameAndLastName;

    @FindBy(xpath = "(//li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[1]")
    private WebElement verifyAddress1;

    @FindBy(xpath = "(//li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[2]")
    private WebElement verifyAddress2;

    @FindBy(xpath = "(//li[contains(@class, 'address_city') and contains(@class, 'address_state_name') and contains(@class, 'address_postcode')])[1]")
    private WebElement verifyCityAndStateAndPostCode;

    @FindBy(xpath = "(//li[@class='address_country_name'])[1]")
    private WebElement verifycountryName;

    @FindBy(xpath = "(//li[@class='address_phone'])[1]")
    private WebElement verifyPhoneNumber;



    //FATURA BİLGİLERİNİ DOĞRULAMA

    @FindBy(xpath = "(//li[contains(@class, 'address_firstname') and contains(@class, 'address_lastname')])[1]")
    private WebElement verifyFirstNameAndLastName2;

    @FindBy(xpath = "(//li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[1]")
    private WebElement verifyAddress12;

    @FindBy(xpath = "(//li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[2]")
    private WebElement verifyAddress22;

    @FindBy(xpath = "(//li[contains(@class, 'address_city') and contains(@class, 'address_state_name') and contains(@class, 'address_postcode')])[1]")
    private WebElement verifyCityAndStateAndPostCode2;

    @FindBy(xpath = "(//li[@class='address_country_name'])[1]")
    private WebElement verifycountryName2;

    @FindBy(xpath = "(//li[@class='address_phone'])[1]")
    private WebElement verifyPhoneNumber2;

    public String getVerifyFirstNameAndLastName() {
        return verifyFirstNameAndLastName.getText().trim();
    }

    public String getVerifyAddress1() {
        return verifyAddress1.getText().trim();
    }

    public String getVerifyAddress2() {
        return verifyAddress2.getText().trim();
    }

    public String getVerifyCityAndStateAndPostCode() {
        return verifyCityAndStateAndPostCode.getText().trim();
    }

    public String getVerifyCountryName() {
        return verifycountryName.getText().trim();
    }

    public String getVerifyPhoneNumber() {
        return verifyPhoneNumber.getText().trim();
    }


    //FATURA BİLGİLERİ METHODLARI
    public String getVerifyFirstNameAndLastName2() {
        return verifyFirstNameAndLastName2.getText().trim();
    }

    public String getVerifyAddress12() {
        return verifyAddress12.getText().trim();
    }

    public String getVerifyAddress22() {
        return verifyAddress22.getText().trim();
    }

    public String getVerifyCityAndStateAndPostCode2() {
        return verifyCityAndStateAndPostCode2.getText().trim();
    }

    public String getVerifyCountryName2() {
        return verifycountryName2.getText().trim();
    }

    public String getVerifyPhoneNumber2() {
        return verifyPhoneNumber2.getText().trim();
    }

    public void inputMessage(){
        message.sendKeys("lksjfopaefvokszpaekfcp");
    }

    public void clickPaymentButton(){
        paymentButton.click();
    }
}
