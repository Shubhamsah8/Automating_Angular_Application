package com.conduit.qa.testcases;

import com.conduit.qa.baseclass.BaseClass;
import com.conduit.qa.pages.HomePage;
import com.conduit.qa.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.conduit.qa.listener.TestListener.class)
public class SignInPageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;

    public SignInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            homePage = new HomePage();
            signInPage = homePage.clickSingIn();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify the SignIn Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("SignIn")
    public void signInTest() throws InterruptedException {
        Thread.sleep(2000);
        signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
        Thread.sleep(2000);

        WebElement profile = driver.findElement(By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[4]/a"));
        String actualUsername = profile.getText();
        Assert.assertEquals(actualUsername, "Shubhamsah086", "The actual book title does not match the expected one.");
    }
}
