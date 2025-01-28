package org.AutomationExerciseTest.utilities;

import org.AutomationExerciseTest.pages.TabbarPage;
import org.testng.Assert;

public class ReusableMethods extends TabbarPage {

    public static void sleep(int miliseconds) throws InterruptedException {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyHomePage() {
        Assert.assertTrue(TabbarPage.viewHomePage.isDisplayed());
        System.out.println("Home page is displayed");
    }
}
