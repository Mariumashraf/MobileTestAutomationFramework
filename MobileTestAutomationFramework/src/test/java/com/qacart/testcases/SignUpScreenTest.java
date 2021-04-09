package com.qacart.testcases;

import com.qacart.base.Base;
import com.qacart.screens.SignupScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpScreenTest extends Base {

    SignupScreen signupScreen = new SignupScreen();

    @BeforeMethod
    public void openSignup(){
        signupScreen.openSignupPage();
    }
    @Test
    public void signup_With_Valid_Information(){
        signupScreen.performSignup("Marium Ashraf","mariam@gmail.com","123456");
    }

    @Test
    public void click_On_Login(){
        signupScreen.clickOnLogin();

    }

    @Test
    public void signup_Without_Email(){
        signupScreen.performSignupWithoutEmail("Marium Ashraf","123456");

    }

}
