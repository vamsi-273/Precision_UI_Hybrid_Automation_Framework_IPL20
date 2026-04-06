package com.ipl.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.ipl.automation.utils.ElementUtils;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    ElementUtils elementUtils;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By teamsTab = By.linkText("TEAMS");

    // Actions
    public String getFooterText() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("footer"), "TEAM"));

        return driver.findElement(By.tagName("footer")).getText();
    }

    public void clickTeams() {
        elementUtils.click(teamsTab);
    }

    public void scrollToFooter() {
        WebElement footer = driver.findElement(By.tagName("footer"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'end'});", footer);
    }
}