package org.AutomationExerciseTest.tests;

import org.AutomationExerciseTest.pages.*;
import org.AutomationExerciseTest.utilities.ConfigurationReader;
import org.AutomationExerciseTest.utilities.Driver;
import org.AutomationExerciseTest.utilities.ReusableMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTestCasesPageTest {
    TabbarPage tabbarPage;
    ReusableMethods reusableMethods;
    TestCasesPage testCasesPage;
    String url = ConfigurationReader.getProperty("address");

    @BeforeMethod
    public void setUp() {
        tabbarPage = new TabbarPage();
        reusableMethods = new ReusableMethods();
        testCasesPage = new TestCasesPage();
    }

    @Test
    public void verifyLoginRegisterPage() {
        Driver.getDriver().get(url);
        reusableMethods.verifyHomePage();
        tabbarPage.clickTestCases();
        testCasesPage.verifyTestCases();

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
