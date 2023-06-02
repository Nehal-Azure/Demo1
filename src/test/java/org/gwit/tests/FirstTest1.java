package org.gwit.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.time.Duration;

public class FirstTest1 {

    @Test
    public void testing1() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".ApiDemos");
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), dc);
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Custom View']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        driver.quit();

    }

    @Test
    public void testing2() throws MalformedURLException {
        UiAutomator2Options option = new UiAutomator2Options();
        option.setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setAppPackage("io.appium.android.apis").setAppActivity(".ApiDemos");
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), option);
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Custom View']")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
        driver.quit();

    }

    @Test
    public void testing3() throws MalformedURLException {

        UiAutomator2Options option2 = new UiAutomator2Options();
        option2.setCapability(AndroidMobileCapabilityType.BROWSER_NAME,"Chrome");
        option2.setAutomationName("UiAutomator2");
        option2.setPlatformName("Android");
        option2.setDeviceName("emulator-5554");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/"), option2);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Yusuf ejazi", Keys.ENTER);



    }
}
