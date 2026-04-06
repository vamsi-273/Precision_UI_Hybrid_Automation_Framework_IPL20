package com.ipl.automation.pages;

import org.openqa.selenium.*;
import java.util.List;
import com.ipl.automation.utils.ElementUtils;
import com.ipl.automation.utils.WaitUtils;

public class NewsPage {

    WebDriver driver;
    ElementUtils elementUtils;
    WaitUtils waitUtils;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    // Locators
    By newsTab = By.xpath("//*[@id=\"myHeader\"]/div/div[3]/div/div/nav/ul/li[5]/a");
    By searchIcon = By.id("searchIconHeader");
    By searchInput = By.id("searchInputForHeader");
    By results = By.xpath("//a[contains(@href,'/news/')]");

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
}