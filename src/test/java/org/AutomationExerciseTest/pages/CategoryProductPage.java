package org.AutomationExerciseTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.AutomationExerciseTest.pages.ProductPage.driver;

public class CategoryProductPage {

    public CategoryProductPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='features_items']//h2//font/font)[1]")
    private WebElement verifyText;

    public void setVerifyText(){
        String expectedText = "Women - Dress Products";
        String actualText = verifyText.getText();
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Doğrulama başarılı");
    }
}
