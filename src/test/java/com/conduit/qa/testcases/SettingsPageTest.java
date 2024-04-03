package com.conduit.qa.testcases;

import com.conduit.qa.baseclass.BaseClass;
import com.conduit.qa.pages.HomePage;
import com.conduit.qa.pages.SettingsPage;
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

public class SettingsPageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;
    public SettingsPage settingsPage;

    public SettingsPageTest(){
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
            settingsPage = homePage.clickSettings();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify the Update Profile")
    @Severity(SeverityLevel.NORMAL)
    @Story("Updating Profile")
    public void profileUpdateTest() throws InterruptedException {
        Thread.sleep(2000);
        settingsPage.profileSettings(properties.getProperty("imageURL"), properties.getProperty("username"), properties.getProperty("bio"), properties.getProperty("email"), properties.getProperty("password"));
        Thread.sleep(3000);

        WebElement pfp = driver.findElement(By.xpath("//div[contains(@class,'col-xs-12 col-md-10')]//img"));
        String profilePicUrl = pfp.getAttribute("src");
        Assert.assertEquals(profilePicUrl, "https://i.pinimg.com/originals/d8/f1/d8/d8f1d8014c7b7eb9a007ef8d5b1270f9.jpg", "The actual book title does not match the expected one.");
    }
}
