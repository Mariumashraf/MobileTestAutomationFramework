package com.qacart.screens;

import com.qacart.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignupScreen extends Base {

    @AndroidFindBy(xpath = "//*[@text='Enter your Full name']")
    private MobileElement fullNameTxt;

    @AndroidFindBy (xpath = "//*[@text='Enter your Email']")
    private MobileElement emailTxt;

    @AndroidFindBy (xpath = "//*[@text='Enter your Password']")
    private MobileElement passwordTxt;

    @AndroidFindBy (xpath = "//*[@text='Signup']")
    private MobileElement signupBtn;

    @AndroidFindBy (xpath = "//*[@text='Login']")
    private MobileElement loginBtn;

    public void openSignupPage(){
        signupBtn.click();
    }

    public void performSignup(String name, String email, String password){
        fullNameTxt.sendKeys(name);
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        signupBtn.click();
    }

    public void performSignupWithoutEmail(String name, String password){
        fullNameTxt.sendKeys(name);
        passwordTxt.sendKeys(password);
        signupBtn.click();
    }

    public void clickOnLogin(){
        loginBtn.click();
    }
}
