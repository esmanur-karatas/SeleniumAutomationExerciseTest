package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//*[@id='form']/div/div/div/div/h2/b")
    private WebElement signUpFormText;

    @FindBy(id = "id_gender2")
    private WebElement genderFemale;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id="days")
    private WebElement day;

    @FindBy(xpath="//select[@id='days']//option[@value='1']")
    private WebElement selectDay;

    @FindBy(id="months")
    private WebElement month;

    @FindBy(xpath="//select[@id='months']//option[@value='4']")
    private WebElement selectMonth;

    @FindBy(id="years")
    private WebElement year;

    @FindBy(xpath="//select[@id='years']//option[@value='2003']")
    private WebElement selectYear;

    @FindBy(id="newsletter")
    private WebElement newsletter;

    @FindBy(id="optin")
    private WebElement option;

    @FindBy(id="first_name")
    protected WebElement firstName;

    @FindBy(id="last_name")
    protected WebElement lastName;

    @FindBy(id="company")
    private WebElement company;

    @FindBy(id="address1")
    private WebElement address;

    @FindBy(id="address2")
    private WebElement address2;

    @FindBy(id="country")
    private WebElement country;

    @FindBy(xpath="//select[@id='country']//option[@value='India']")
    private WebElement selectCountry;

    @FindBy(id="state")
    private WebElement state;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="zipcode")
    private WebElement zipcode;

    @FindBy(id="mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccount;

    public void verifySignUpFormText() {
        Assert.assertTrue(signUpFormText.isDisplayed());
        System.out.println("Sign up page is displayed");

    }

    public void selectGender() {
        genderFemale.click();
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void selectDay() {
        day.click();
        selectDay.click();
    }

    public void selectMonth() {
        month.click();
        selectMonth.click();
    }

    public void selectYear() {
        year.click();
        selectYear.click();
    }

    public void selectCountry() {
        country.click();
        selectCountry.click();
    }

   public void clickNewsletter(){
        newsletter.click();
    }

    public void clickOption() {
        option.click();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setCompany(String company) {
        this.company.sendKeys(company);
    }

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setAddress2(String address2) {
        this.address2.sendKeys(address2);
    }

    public void setCountry() {
        country.click();
        selectCountry.click();
    }

    public void setState(String state) {
        this.state.sendKeys(state);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setZipcode(String zipcode) {
        this.zipcode.sendKeys(zipcode);
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber.sendKeys(mobileNumber);
    }

    public void createAccount() {
        createAccount.click();
    }

}
