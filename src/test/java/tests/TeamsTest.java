package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.TeamsPage;
import com.ipl.automation.utils.JsonDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TeamsTest extends BaseTest {
    Logger log = LogManager.getLogger(TeamsTest.class);

    @Test
    public void verifyTeamDetails() {

        log.info("---------------Case 2: Teams Hover Test---------------");

        TeamsPage teamsPage = new TeamsPage(driver);

        log.info("Navigating to Teams page");
        teamsPage.clickTeams();

        teamsPage.acceptCookies();

        String[] expectedTeams = JsonDataProvider.getTeamNames();
        List<WebElement> teams = teamsPage.getAllTeams();
        log.info("Total number teams listed: {}", teams.size());

        for (WebElement team : teams) {

            String actualName = teamsPage.getTeamName(team);
            log.info("Validating team: {}", actualName);

            boolean found = false;

            for (String expected : expectedTeams) {
                if (actualName.equals(expected)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                log.error("Unexpected team found: {}", actualName);
            }
            Assert.assertTrue(found, "Unexpected team: " + actualName);

            // Logo Displayed or not
            boolean logoDisplayed = teamsPage.isLogoDisplayed(team);
            log.debug("Logo displayed for {}: {}", actualName, logoDisplayed);

            if (!logoDisplayed) {
                log.error("Logo not displayed for: {}", actualName);
            }
            Assert.assertTrue(logoDisplayed, "Logo not displayed for: " + actualName);

            // Hover
            log.debug("Hovering on team: {}", actualName);
            teamsPage.hoverOnTeam(team);

            // Winning year validation
            String years = teamsPage.getWinningYears(team);

            String output = (years != null && years.contains("20")) ? years : "No trophies";

            log.info("Team: {}", actualName);
            log.info("Winning years: {}", output);

            log.info("");
        }

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}