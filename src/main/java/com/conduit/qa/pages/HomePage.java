package com.conduit.qa.pages;

import com.conduit.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@routerlink='/login']")
    WebElement singIn;

    @FindBy(xpath = "//a[@routerlink='/settings']")
    WebElement settings;

    @FindBy(xpath = "//a[@routerlink='/editor']")
    WebElement newArticle;

    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[4]/a")
    WebElement profile;

    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[1]/a")
    WebElement home;

    @FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/a")
    WebElement conduit;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[1]/a")
    WebElement yourFeed;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a")
    WebElement globalFeed;

    @FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/a")
    WebElement firstPost;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickSingIn(){
        singIn.click();

        return new SignInPage();
    }

    public NewArticlePage clickNewArticle(){
        newArticle.click();

        return new NewArticlePage();
    }

    public SettingsPage clickSettings(){
        settings.click();

        return new SettingsPage();
    }

    public ProfilePage clickProfile(){
        singIn.click();

        return new ProfilePage();
    }

    public void clickFirstPost(){
        firstPost.click();
    }

}
