package com.ipl.automation.pages;

import com.ipl.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class TicketsPage {

    WebDriver driver;
    WaitUtils wait;

    public TicketsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Locators
    By ticketsTab = By.xpath("//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='TICKETS']");
    By buyTicketsBtn = By.xpath("(//a[@title='Buy Tickets'])[2]");
    By matchCentreBtn = By.xpath("(//a[@class='vn-matchBtn ng-scope'][normalize-space()='Match Centre'])[2]");

    // Actions

    public void goToTickets() {
        wait.waitForElementClickable(ticketsTab).click();
    }

    public boolean isBuyTicketsEnabled() {
        WebElement btn = wait.waitForElementVisible(buyTicketsBtn);
        return btn.isDisplayed() && btn.isEnabled();
    }

    public void clickBuyTickets() {

        WebElement element = wait.waitForElementPresence(buyTicketsBtn);

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        // Wait until clickable
        wait.waitForElementClickable(element);

        element.click();
    }

    public boolean isNewTabOpenedAfterClick() {

        // Step 1: Store current windows
        int beforeCount = driver.getWindowHandles().size();

        // Step 2: Click Buy Tickets
        clickBuyTickets();

        // Step 3: Wait until new tab appears
        wait.waitForNewWindow(beforeCount);

        int afterCount = driver.getWindowHandles().size();

        return afterCount > beforeCount;
    }

    public void clickMatchCentre() {
        WebElement element = wait.waitForElementClickable(matchCentreBtn);
        element.click();
    }

    public boolean isVenueVisible() {
        return Objects.requireNonNull(driver.getPageSource()).toLowerCase().contains("venue");
    }

    // Accept cookies
    public void acceptCookies() {
        try {
            WebElement acceptBtn = wait.waitForElementClickable(By.xpath("//button[contains(text(),'Accept')]"));
            acceptBtn.click();
        } catch (Exception e) {
            System.out.println("No cookie popup");
        }
    }
}