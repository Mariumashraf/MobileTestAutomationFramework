package com.qacart.testcases;

import com.qacart.base.Base;
import com.qacart.screens.LoginScreen;
import org.testng.annotations.Test;

public class LoginScreenTest extends Base {
    LoginScreen loginScreen ;

    @Test
    public void login_Test_With_Valid_Credintials(){
        loginScreen = new LoginScreen();
        loginScreen.fillEmailAndPassword("mariam@gmail.com","123456");
    }

    @Test
    public void login_Test_With_Empty_Email(){

    }

    @Test
    public void login_Test_With_Empty_Password(){

    }

    @Test
    public void login_Test_Click_On_Signup(){

    }


}
