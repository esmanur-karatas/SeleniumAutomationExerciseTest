package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.List;

public class ProductDetailPage {
    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[text()='Blue Top']")
    private WebElement productName;

    @FindBy(xpath = "//p[text()='Category: Women > Tops']")
    private WebElement productCategory;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    private WebElement productPrice;

    @FindBy(xpath = "//p[text()=' In Stock']")
    private WebElement producyAvailability;

    @FindBy(xpath = "//p[text()=' New']")
    private WebElement prductCondition;

    @FindBy(xpath = "//p[text()=' Polo']")
    private WebElement productBrand;

    @FindBy(id = "quantity")
    private WebElement productQuantityCount;

    @FindBy(xpath = "(//button//i)[1]")
    private WebElement addToBasket;

    @FindBy(xpath = "//a[@href='#reviews']")
    private WebElement writeYourReviewsTextView;

    @FindBy(id = "name")
    private WebElement commentNameInput;

    @FindBy(id = "email")
    private WebElement commentEmailInput;

    @FindBy(xpath = "//textarea[@id='review']")
    private WebElement commentMessageInput;

    @FindBy(id = "button-review")
    private WebElement commentSubmitButton;

    @FindBy(xpath = "//*[@id=\"review-section\"]/div/div")
    private WebElement successTextVerify;

    @FindBy(xpath = "//div[@class='brands-name']//ul//li// a")
    private List<WebElement> viewMarkaList;

    public void verifyProductName() {
        Assert.assertTrue(productName.isDisplayed());
        System.out.println("Product Name: " + productName.getText());
    }
    public void verifyProductCategory() {
        Assert.assertTrue(productCategory.isDisplayed());
        System.out.println("Product Category: " + productCategory.getText());
    }
    public void verifyProductPrice() {
        Assert.assertTrue(productPrice.isDisplayed());
        System.out.println("Product Price: " + productPrice.getText());
    }
    public void verifyProductAvailability() {
        Assert.assertTrue(producyAvailability.isDisplayed());
        System.out.println("Product Availability: " + producyAvailability.getText());
    }
    public void verifyPrductCondition() {
        Assert.assertTrue(prductCondition.isDisplayed());
        System.out.println("Product Condition: " + prductCondition.getText());
    }
    public void verifyProductBrand() {
        Assert.assertTrue(productBrand.isDisplayed());
        System.out.println("Product Brand: " + productBrand.getText());
    }
    public void productQuantityCount() throws InterruptedException {
        productQuantityCount.clear();
        productQuantityCount.sendKeys("4", Keys.TAB);
        Thread.sleep(3000);
    }
    public void clickAddToBasket(){
        addToBasket.click();
    }

    public void setVerifyWriteYourReviewsTextView(){
        Assert.assertTrue(writeYourReviewsTextView.isDisplayed());
        System.out.println("Başarıyla doğrulandı");
    }

    public void setCommentNameInput(String name){
        commentNameInput.sendKeys(name);
    }

    public void setCommentEmailInput(String email){
        commentNameInput.sendKeys(email);
    }

    public void setCommentMessageInput(String message){
        commentNameInput.sendKeys(message);
    }

    public void setCommentSubmitButton(){
        commentSubmitButton.click();
    }

    public void setSuccessTextVerify(){
        Assert.assertTrue(successTextVerify.isEnabled());
        System.out.println("Doğrulama başarılı");
    }

    public void setViewMarkaList(){
        Assert.assertFalse(viewMarkaList.isEmpty(), "Arama sonucu boş! Hiç ürün bulunamadı.");
        for (WebElement product : viewMarkaList) {
            Assert.assertTrue(product.isDisplayed(), "Ürün görünür değil: " + product.getText());
        }

        System.out.println("Tüm markalar başarıyla görüntüleniyor.\nToplam " + viewMarkaList.size() + " marka bulundu.");
        WebElement firstProduct = viewMarkaList.get(0);
        firstProduct.click();
    }

    public void setClickBrand(){
        WebElement secondProduct = viewMarkaList.get(1);
        secondProduct.click();
    }

}
