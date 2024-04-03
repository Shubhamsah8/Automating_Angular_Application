package com.conduit.qa.testcases;

import com.conduit.qa.baseclass.BaseClass;
import com.conduit.qa.pages.HomePage;
import com.conduit.qa.pages.ProfilePage;
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

public class ProfilePageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;
    public ProfilePage profilePage;

    public ProfilePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            homePage = new HomePage();
            signInPage = homePage.clickSingIn();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            Thread.sleep(2000);
            profilePage = homePage.clickProfile();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify the Published Post in the Profile")
    @Severity(SeverityLevel.NORMAL)
    @Story("Post in Profile")
    public void postInProfileTest() throws InterruptedException {

        WebElement postTitle = driver.findElement(By.xpath("//a[@class='preview-link']//h1"));
        String postHeader = postTitle.getText();
        Assert.assertEquals(postHeader, "First Post", "The actual book title does not match the expected one.");
    }
}
