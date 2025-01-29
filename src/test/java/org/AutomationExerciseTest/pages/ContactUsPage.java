package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsPage {
    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@class='title text-center' and contains(text(), 'Get In Touch')]")
    private WebElement verifyContactUs;

    @FindBy(xpath = "//input[@data-qa=\"name\"]")
    private WebElement nameField;

    @FindBy(xpath = "//input[@data-qa=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-qa=\"subject\"]")
    private WebElement subjectField;

    @FindBy(xpath = "//textarea[@data-qa=\"message\"]")
    private WebElement messageField;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFile;

    @FindBy(name = "submit")
    private WebElement submitButton;

    public void verifyContactUs() {
        Assert.assertTrue(verifyContactUs.isDisplayed());
        String veriftext = verifyContactUs.getText();
        System.out.println(veriftext);
    }

    public void name(String name) {
        nameField.sendKeys(name);
    }
    public void email(String email) {
        emailField.sendKeys(email);
    }
    public void subject(String subject) {
        subjectField.sendKeys(subject);
    }
    public void message(String message) {
        messageField.sendKeys(message);
    }
    public void uploadFile() {
        uploadFile.sendKeys("C:\\Users\\Huawei\\Downloads\\Q2B_OR.png");
        // yüklemek istediğiniz dosyayı seçelim
        String filePath = System.getProperty("user.home") + "\\Downloads\\Q2B_OR.png";
        uploadFile.sendKeys(filePath);

    }
    public void submitButton() {
        submitButton.click();
    }
}
