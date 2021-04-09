package com.qacart.testcases;

import com.qacart.base.Base;
import com.qacart.screens.NewTaskScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NewTaskScreenTest extends Base {
   /* @Test
    public void lunch() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Marium");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\safa\\MobileTestAutomationFramework\\Apps\\QAcart-To-Do.apk");
        AndroidDriver driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }*/
    NewTaskScreen newTaskScreen = new NewTaskScreen();
    @Test
    public void add_New_Task(){
        newTaskScreen.addNewTask("Study Performance Testing");

    }

    @Test
    public void press_On_Cancel(){
        newTaskScreen.clickOnCancel();
    }
}
