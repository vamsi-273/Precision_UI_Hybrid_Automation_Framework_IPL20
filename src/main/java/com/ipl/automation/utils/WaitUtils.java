package com.ipl.automation.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WaitUtils {

    WebDriver driver;
    WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForNewWindow(int previousWindowCount) {
        wait.until(driver -> driver.getWindowHandles().size() > previousWindowCount);
    }

    public List<WebElement> waitForElementsVisible(By locator) {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            return new ArrayList<>(); // safe fallback
        }
    }
}