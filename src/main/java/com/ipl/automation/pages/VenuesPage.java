package com.ipl.automation.pages;


import com.ipl.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class VenuesPage {

    WebDriver driver;
    WaitUtils wait;

    public VenuesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // Locators
    By moreMenu = By.xpath("//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='MORE']");
    By venuesOption = By.xpath("//ul[contains(@class,'dropdown arrow-top')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='VENUES']");
    By venueNames = By.xpath("//div[@class='np-venu_inner--text col-100 floatLft absolute']//span");

    public void goToVenues() {
        WebElement element_1 = wait.waitForElementClickable(moreMenu);
        element_1.click();
        WebElement element_2 = wait.waitForElementClickable(venuesOption);
        element_2.click();
    }

    public List<String> getAllVenueNames() {

        List<WebElement> elements = wait.waitForElementsVisible(venueNames);

        List<String> names = new ArrayList<>();

        for (WebElement el : elements) {
            names.add(el.getText().trim());
        }

        return names;
    }
}