package com.ipl.automation.pages;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;
import com.ipl.automation.utils.ElementUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamsPage {

    WebDriver driver;
    ElementUtils elementUtils;
    WebDriverWait wait;

    public TeamsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator for all team cards
    By teamCards = By.xpath("//a[contains(@class,'w-100')]");

    // Inside each card
    By teamLogo = By.xpath(".//img");

    // Get all teams
    public List<WebElement> getAllTeams() {
        return driver.findElements(teamCards);
    }

    // Verify logo displayed
    public boolean isLogoDisplayed(WebElement team) {
        return team.findElement(teamLogo).isDisplayed();
    }

    // Hover on team
    public void hoverOnTeam(WebElement team) {
        elementUtils.hover(team);
    }

    // Get trophy years text
    public String getWinningYears(WebElement team) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to element
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", team);

        // Wait until element is visible
        wait.until(ExpectedConditions.visibilityOf(team));

        // Hover on element
        Actions actions = new Actions(driver);
        actions.moveToElement(team).perform();

        // Wait until text changes / appears (after hover)
        wait.until(driver -> !team.getText().isEmpty());

        return team.getText();
    }

    // get team names
    public String getTeamName(WebElement team) {
        try {
            return team.getText();
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    // Accept cookies
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