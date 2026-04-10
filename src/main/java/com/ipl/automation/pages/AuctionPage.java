package com.ipl.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AuctionPage {

    WebDriver driver;
    WebDriverWait wait;

    public AuctionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Locators
    By moreMenu = By.xpath("//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='MORE']");
    By auctionOption = By.xpath("//ul[contains(@class,'dropdown arrow-top')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='AUCTION']");
    By acceptCookiesBtn = By.xpath("//button[contains(text(),'Accept')]");
    By topBuysTab = By.xpath("//a[@id='Top_Buys_click']");
    By playerNames = By.xpath("//body[1]/div[1]/div[4]/div[1]/section[1]/div[2]/section[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]");
    By playerPrices = By.xpath("//td[contains(text(),'₹25,20,00,000')]");

    // First player (most valuable)

    // 🔹 Actions

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

    public void openAuctionPage() {

        // Hover on MORE
        WebElement more = wait.until(ExpectedConditions.visibilityOfElementLocated(moreMenu));

        Actions actions = new Actions(driver);
        actions.moveToElement(more).perform();

        // Wait for AUCTION
        WebElement auction = wait.until(
                ExpectedConditions.visibilityOfElementLocated(auctionOption)
        );

        // Click AUCTION
        auction.click();
    }

    public void slowScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,300)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void clickTopBuys() {

        WebElement tab = wait.until(
                ExpectedConditions.presenceOfElementLocated(topBuysTab)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to element
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", tab);

        try { Thread.sleep(1000); } catch (Exception e) {}

        // Click using JS
        js.executeScript("arguments[0].click();", tab);

        // 🔥 IMPORTANT: Wait for table to load
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table//tr")
        ));
    }
    public String getTopPlayerName() {

        WebElement firstPlayer = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(playerNames)
        ).get(0);

        return firstPlayer.getText();
    }

    public int getTopPlayerPrice() {

        WebElement firstPrice = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(playerPrices)
        ).get(0);

        String priceText = firstPrice.getText().replaceAll("[^0-9]", "");

        return Integer.parseInt(priceText);
    }
}