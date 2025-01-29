package org.AutomationExerciseTest.pages;

import org.AutomationExerciseTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCasesPage {
    public TestCasesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div h2 b")
    private WebElement viewTestCases;

    public void verifyTestCases() {
        Assert.assertTrue(viewTestCases.isDisplayed());
        System.out.println("Test Cases Page Success");
    }
}
