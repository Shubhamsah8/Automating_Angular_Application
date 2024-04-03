package com.conduit.qa.testcases;

import com.conduit.qa.baseclass.BaseClass;
import com.conduit.qa.pages.HomePage;
import com.conduit.qa.pages.SignInPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            homePage = new HomePage();
            signInPage = homePage.clickSingIn();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify the Post")
    @Severity(SeverityLevel.MINOR)
    @Story("Post")
    public void postTest() throws InterruptedException {
        Thread.sleep(5000);
        homePage.clickFirstPost();
        Thread.sleep(2000);

        WebElement postHeading = driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/h1"));
        String headingText = postHeading.getText();
        Assert.assertEquals(headingText, "Ill quantify the redundant TCP bus, that should hard drive the ADP bandwidth!", "The actual book title does not match the expected one.");
    }
}
