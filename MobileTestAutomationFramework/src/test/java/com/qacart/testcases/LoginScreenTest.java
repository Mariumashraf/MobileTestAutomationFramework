package com.qacart.testcases;

import com.qacart.base.Base;
import com.qacart.screens.LoginScreen;
import org.testng.annotations.Test;

public class LoginScreenTest extends Base {
    LoginScreen loginScreen = new LoginScreen(); ;

    @Test
    public void login_Test_With_Valid_Credintials(){
        loginScreen.performLogin("mariam@gmail.com","123456");
    }

    @Test
    public void login_Test_With_Empty_Email(){
        loginScreen.performLoginWithoutEmail("123456");

    }

    @Test
    public void login_Test_With_Empty_Password(){
        loginScreen.performLoginWithoutPassword("mariam@gmail.com");

    }

    @Test
    public void login_Test_Click_On_Signup(){
        loginScreen.clickOnSignup();

    }


}
