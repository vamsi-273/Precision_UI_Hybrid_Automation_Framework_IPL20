package com.ipl.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.ipl.automation.utils.ElementUtils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
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
    private final By footer = By.tagName("footer");

    private final By teamSection = By.xpath("//*[@id='footer-main']/div[2]/div[1]/div[1]");
    private final By aboutSection = By.xpath("//*[@id='footer-main']/div[2]/div[1]/div[2]");
    private final By guidelinesSection = By.xpath("//*[@id='footer-main']/div[2]/div[1]/div[3]");
    private final By contactSection = By.xpath("//*[@id='footer-main']/div[2]/div[1]/div[4]");

    // Actions
    public void scrollToFooter() {
        WebElement footerElement = driver.findElement(footer);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'end'});", footerElement);
    }

    // General method
    private List<String> getLinks(By locator) {
        List<String> linksText = new ArrayList<>();

        List<WebElement> links = driver.findElements(locator);

        for (WebElement link : links) {
            linksText.add(link.getText());
        }

        return linksText;
    }

    // Methods for each section
    public List<String> getTeamLinks() {
        return getLinks(teamSection);
    }

    public List<String> getAboutLinks() {
        return getLinks(aboutSection);
    }

    public List<String> getGuidelineLinks() {
        return getLinks(guidelinesSection);
    }

    public List<String> getContactLinks() {
        return getLinks(contactSection);
    }
}