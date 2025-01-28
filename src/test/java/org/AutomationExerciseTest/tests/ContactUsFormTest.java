package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsFormTest {
    WebDriver driver;
    TabbarPage tabbarPage;
    LoginRegisterPage loginRegisterPage;
    ReusableMethods reusableMethods;
    ContactUsPage contactUsPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(url);
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        loginRegisterPage = new LoginRegisterPage();
        contactUsPage = new ContactUsPage();
    }

    @Test
    public void contactUsFormTest() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
     //   tabbarPage.contactUsButton();
        contactUsPage.verifyContactUs();
        contactUsPage.name("John Doe");
        contactUsPage.email("john@doe.com");
        contactUsPage.subject("skdnfcksndfıjeoıwsf");
        contactUsPage.message("sdjfoıejowqı9osı9QSMEUJ");
        contactUsPage.uploadFile();
        contactUsPage.submitButton();
        Alert alert = driver.switchTo().alert();
        System.out.println("Pop-up mesajı: " + alert.getText());
        alert.accept();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
