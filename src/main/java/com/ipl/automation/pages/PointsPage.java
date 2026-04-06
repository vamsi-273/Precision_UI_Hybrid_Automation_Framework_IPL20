package com.ipl.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ipl.automation.utils.ElementUtils;
import com.ipl.automation.utils.WaitUtils;

public class PointsPage {

    WebDriver driver;
    ElementUtils elementUtils;
    WaitUtils waitUtils;

    public PointsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    // 🔹 Locators
    By pointsTab = By.linkText("POINTS TABLE");

    By topTeamName = By.xpath("(//h2[contains(@class,'ih-pt-cont')])[1]");
    By matchesPlayed = By.xpath("(//table//tr)[2]//td[4]");
    By points = By.xpath("(//table//tr)[2]//td[last()-1]");

    // 🔹 Actions

    public void clickPointsTable() {
        elementUtils.click(pointsTab);
    }

    public String getTopTeamName() {
        return elementUtils.getText(topTeamName);
    }

    public int getTopTeamMatchesPlayed() {
        return Integer.parseInt(elementUtils.getText(matchesPlayed));
    }

    public int getTopTeamPoints() {
        return Integer.parseInt(elementUtils.getText(points));
    }
}