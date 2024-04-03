package com.conduit.qa.pages;

import com.conduit.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInPage extends BaseClass {

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signIn;

    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage SignIn(String emailInput, String passInput){
        email.sendKeys(emailInput);
        password.sendKeys(passInput);
        signIn.click();

        return new HomePage();
    }
}
