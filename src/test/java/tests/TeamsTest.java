package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.HomePage;
import com.ipl.automation.pages.TeamsPage;
import com.ipl.automation.utils.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TeamsTest extends BaseTest {

    @Test
    public void verifyTeamDetails() {

        HomePage homePage = new HomePage(driver);

        // Navigate
        homePage.clickTeams();

        TeamsPage teamsPage = new TeamsPage(driver);
        teamsPage.acceptCookies();

        String[] expectedTeams = TestData.getTeamNames();
        List<WebElement> teams = teamsPage.getAllTeams();

        for (WebElement team : teams) {

            String actualName = teamsPage.getTeamName(team);

            boolean found = false;

            for (String expected : expectedTeams) {
                if (actualName.equals(expected)) {
                    found = true;
                    break;
                }
            }

            Assert.assertTrue(found, "Unexpected team: " + actualName);

            Assert.assertTrue(
                    teamsPage.isLogoDisplayed(team),
                    "Logo not displayed for: " + actualName
            );

            teamsPage.hoverOnTeam(team);

            String years = teamsPage.getWinningYears(team);

            String output = (years != null && years.contains("20"))
                    ? years
                    : "No trophies";

            System.out.println("Team: " + actualName);
            System.out.println("Winning years: " + output + "\n");
        }
    }
}