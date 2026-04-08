package com.ipl.automation.base;

import com.ipl.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.ipl.automation.utils.ScreenshotUtils;

public class BaseTest {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        driver = DriverFactory.initDriver(browser);
        driver.get(ConfigReader.get("baseURL"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // If test fails → take screenshot
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.capture(driver, result.getName());
        }
        DriverFactory.quitDriver();
    }
}