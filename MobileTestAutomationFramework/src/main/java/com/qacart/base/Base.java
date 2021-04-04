package com.qacart.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Base {
    protected static AndroidDriver<MobileElement> driver;
    protected FileInputStream inputStream;
    protected Properties properties;

    @BeforeClass
    @Parameters({"deviceName", "platformName", "platformVersion"})
    public void befoeClass(String deviceName, String platformName, String platformVersion) throws IOException {
        File propFile = new File("src/main/resources/config/config.properties");
        inputStream = new FileInputStream(propFile);
        properties = new Properties();
        properties.load(inputStream);

        if (platformName.equalsIgnoreCase("Android")) {
            File androidApp = new File(properties.getProperty("androidAppPath"));
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
            driver = new AndroidDriver<MobileElement>(new URL(properties.getProperty("appiumServer")), desiredCapabilities);
        } else if (platformName.equalsIgnoreCase("IOS")) {
            File iosApp = new File(properties.getProperty("iosAppPath"));
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("iosAutomationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, iosApp.getAbsolutePath());
            driver = new AndroidDriver<MobileElement>(new URL(properties.getProperty("appiumServer")), desiredCapabilities);

        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
