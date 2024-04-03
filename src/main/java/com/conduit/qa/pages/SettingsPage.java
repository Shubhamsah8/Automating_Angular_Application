package com.conduit.qa.pages;

import com.conduit.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BaseClass {

    @FindBy(xpath = "//input[@placeholder='URL of profile picture']")
    WebElement urlOfProfile;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameInSettings;

    @FindBy(xpath = "//textarea[@placeholder='Short bio about you']")
    WebElement bio;

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailInSettings;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    WebElement newPassword;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/form/fieldset/button")
    WebElement updateSettings;

    @FindBy(xpath = "/html/body/app-root/app-settings-page/div/div/div/div/button")
    WebElement logout;

    public SettingsPage(){
        PageFactory.initElements(driver, this);
    }

    public void profileSettings(String profileURL, String usernameInput, String bioInput, String emailInput, String newPasswordInput){
        urlOfProfile.sendKeys(profileURL);
        usernameInSettings.sendKeys(usernameInput);
        bio.sendKeys(bioInput);
        emailInSettings.sendKeys(emailInput);
        newPassword.sendKeys(newPasswordInput);

        updateSettings.click();
    }

    public HomePage UserLogout(){
        logout.click();

        return new HomePage();
    }
}
