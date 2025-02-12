package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {
    WebDriver driver;
    JavascriptExecutor js;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "recommended-item-carousel")
    private WebElement recommendedItemCarousel;

    @FindBy(xpath = "(//a[@data-product-id=\"1\"])[3]")
    private WebElement addToCart;

    @FindBy(xpath = "(//a[@href=\"/view_cart\"])[2]")
    private WebElement viewCartButton;

    @FindBy(id = "scrollUp")
    private WebElement homeScrollUp;

    @FindBy(xpath = "(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]")
    private WebElement verifySliderText;



    public void scrollHomePageDown() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollHomePageUp() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void setRecommendedItemCarousel(){
        Assert.assertTrue(recommendedItemCarousel.isDisplayed());
    }

    public void setAddToCart(){
        addToCart.click();
    }

    public void setViewCartButtonClick(){
        viewCartButton.click();
    }

    public void setHomeScrollUp(){
        homeScrollUp.click();
    }

    public void setVerifySliderText(){
        Assert.assertTrue(verifySliderText.isDisplayed());
        System.out.println("Doğrulama başarılı: " +verifySliderText.getText());
    }


}
