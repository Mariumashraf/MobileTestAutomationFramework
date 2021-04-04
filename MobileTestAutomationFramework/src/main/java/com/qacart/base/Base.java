package com.qacart.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    protected static AndroidDriver<MobileElement> driver;
    protected FileInputStream inputStream;
    protected Properties properties;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    @BeforeSuite
    public void beforeSuite(){
        extentReports = new ExtentReports("Reports/index.html");
        extentReports.addSystemInfo("Framework","Mobile Test Automation Framework");
        extentReports.addSystemInfo("Tester", "Marium Ashraf");
        extentReports.addSystemInfo("Paltform", "Android");
    }
    @AfterSuite
    public void afterSuite(){
        extentReports.flush();
    }
    @BeforeMethod
    public void beforeMethod(Method method){
        logger = extentReports.startTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult iTestResult){
        File image = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(image,new File("Snapshots/" + method.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imagePath = System.getProperty("user.dir") + File.separator + "Snapshots/" + method.getName() + ".png";
        if(iTestResult.getStatus() == ITestResult.SUCCESS){
            logger.log(LogStatus.PASS,"Test passed");
            logger.log(LogStatus.PASS,logger.addScreenCapture(imagePath));

        }else if(iTestResult.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL,"Test Failed");
            logger.log(LogStatus.FAIL,iTestResult.getThrowable());
            logger.log(LogStatus.FAIL,logger.addScreenCapture(imagePath));
        }else {
            logger.log(LogStatus.SKIP, "Test is Skipped");
        }

    }
    public Base(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
