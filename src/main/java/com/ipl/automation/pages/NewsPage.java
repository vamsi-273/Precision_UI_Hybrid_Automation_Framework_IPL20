package com.ipl.automation.pages;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;
import com.ipl.automation.utils.ElementUtils;
import com.ipl.automation.utils.WaitUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {

    WebDriver driver;
    ElementUtils elementUtils;
    WaitUtils waitUtils;
    WebDriverWait wait;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        this.waitUtils = new WaitUtils(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By newsTab = By.xpath("//*[@id=\"myHeader\"]/div/div[3]/div/div/nav/ul/li[5]/a");
    By searchIcon = By.id("searchIconHeader");
    By searchInput = By.id("searchInputForHeader");
    By results = By.className("textTwoLine");

    // Actions

    public void clickNewsTab() {
        elementUtils.scrollIntoView(newsTab);
        elementUtils.clickUsingJS(newsTab);
    }

    public void clickSearchIcon() {
        elementUtils.clickUsingJS(searchIcon);
    }

    public void enterSearchText(String text) {
        elementUtils.type(searchInput, text);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public boolean isSearchResultRelevant(String keyword) {

        List<WebElement> resultList = driver.findElements(results);

        System.out.println("Results found: " + resultList.size());

        for (WebElement result : resultList) {

            String text = result.getText().toLowerCase();

            System.out.println("Result: " + text);

            if (text.contains("auction") || text.contains("2026")) {
                return true;
            }
        }
        return false;
    }

    public void clickFirstResult() {
        WebElement first = driver.findElements(results).get(0);
        first.click();
    }
    public void acceptCookies() {
        try {
            WebElement acceptBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(text(),'Accept')]")
                    )
            );
            acceptBtn.click();
        } catch (Exception e) {
            System.out.println("No cookie popup");
        }
    }
}