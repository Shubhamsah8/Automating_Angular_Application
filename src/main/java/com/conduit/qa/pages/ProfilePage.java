package com.conduit.qa.pages;

import com.conduit.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {

    @FindBy(xpath = "/html/body/app-root/app-profile-page/div/div[1]/div/div/div/a")
    WebElement editProfileSettings;

    @FindBy(xpath = "/html/body/app-root/app-profile-page/div/div[2]/div/div/div/ul/li[1]/a")
    WebElement myPosts;

    @FindBy(xpath = "/html/body/app-root/app-profile-page/div/div[2]/div/div/div/ul/li[2]/a")
    WebElement favouritePosts;

    public ProfilePage(){
        PageFactory.initElements(driver, this);
    }

    public SettingsPage returnToSettings(){
        editProfileSettings.click();

        return new SettingsPage();
    }

    public void clickMyPosts(){
        myPosts.click();
    }

    public void clickFavouritePosts(){
        favouritePosts.click();
    }
}
