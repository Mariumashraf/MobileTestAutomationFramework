package com.qacart.screens;

import com.qacart.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginScreen extends Base {

    @AndroidFindBy (xpath = "//android.widget.EditText[@index='1']")
    private MobileElement emailField;
    @AndroidFindBy (xpath = "//android.widget.EditText[@index='2']")
    private MobileElement passwordField;

    @AndroidFindBy (xpath = "//*[@text='Login']")
    private MobileElement loginBtn;

    public void fillEmailAndPassword(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }


}
