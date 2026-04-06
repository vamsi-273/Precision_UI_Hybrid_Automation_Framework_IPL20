package com.ipl.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {

    WebDriver driver;
    WaitUtils wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void click(By locator) {
        wait.waitForElementClickable(locator).click();
    }

    public void type(By locator, String text) {
        wait.waitForElementVisible(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return wait.waitForElementVisible(locator).getText();
    }

    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(wait.waitForElementVisible(locator)).perform();
    }

    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(1500).perform();
    }

    public void clickUsingJS(By locator) {
        WebElement element = wait.waitForElementVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoView(By locator) {
        WebElement element = wait.waitForElementVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}