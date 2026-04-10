package com.ipl.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StatsPage {

    WebDriver driver;
    WebDriverWait wait;

    public StatsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By moreMenu = By.xpath("//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='MORE']");
    By statsOption = By.xpath("//div[contains(@class,'site-navbar-wrap')]//li[contains(@class,'has-children')]//li[1]");
    By acceptCookiesBtn = By.xpath("//button[contains(text(),'Accept')]");
    // Example locators (may slightly vary — adjust if needed)

    By pageHeader = By.xpath("//h1[contains(text(),'Stats') or contains(text(),'STATS')]");

    // First player row
    By firstPlayerName = By.xpath("(//table//tr)[2]//td[2]");
    By firstPlayerRuns = By.xpath("(//table//tr)[2]//td[contains(@class,'runs') or position()=3]");
    // Actions


    public void openStatsPage() {

        // Hover on MORE
        WebElement more = wait.until(ExpectedConditions.visibilityOfElementLocated(moreMenu));

        Actions actions = new Actions(driver);
        actions.moveToElement(more).perform();

        // Wait for STATS to be visible
        WebElement stats = wait.until(ExpectedConditions.visibilityOfElementLocated(statsOption));

        // Click STATS
        stats.click();
    }

    public void acceptCookies() {
        try {
            WebElement accept = wait.until(
                    ExpectedConditions.elementToBeClickable(acceptCookiesBtn)
            );
            accept.click();
        } catch (Exception e) {
            System.out.println("No cookie popup");
        }
    }
    public void slowScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,300)");
            try {
                Thread.sleep(500); // slow scroll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isStatsPageLoaded() {
        return driver.findElement(pageHeader).isDisplayed();
    }

    public String getTopPlayerName() {
        return driver.findElement(firstPlayerName).getText();
    }

    public int getTopPlayerRuns() {
        String runs = driver.findElement(firstPlayerRuns).getText();
        return Integer.parseInt(runs);
    }

}