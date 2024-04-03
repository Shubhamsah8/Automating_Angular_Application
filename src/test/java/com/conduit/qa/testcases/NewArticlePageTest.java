package com.conduit.qa.testcases;

import com.conduit.qa.baseclass.BaseClass;
import com.conduit.qa.pages.HomePage;
import com.conduit.qa.pages.NewArticlePage;
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

public class NewArticlePageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;
    public NewArticlePage newArticlePage;

    public NewArticlePageTest(){
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
            newArticlePage = homePage.clickNewArticle();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Description("Verify the publish Post feature")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Publish Post")
    public void publishPostTest() throws InterruptedException {
        Thread.sleep(2000);
        newArticlePage.PublishArticle(properties.getProperty("postTitle"), properties.getProperty("postDescription"), properties.getProperty("writePost"), properties.getProperty("tags"));
        Thread.sleep(3000);

        WebElement postTitle = driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/h1"));
        String Title = postTitle.getText();
        Assert.assertEquals(Title, "First Post", "The actual book title does not match the expected one.");
    }
}
