package tests;

import com.ipl.automation.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.ipl.automation.pages.PointsPage;
import org.testng.Assert;
import com.ipl.automation.utils.JsonDataProvider;

public class PointsTableTest extends BaseTest {

    Logger log = LogManager.getLogger(PointsTableTest.class);

    @Test
    public void openPointsTable() {

        log.info("---------------Case 3: Points Table Test---------------");

        PointsPage pointsPage = new PointsPage(driver);

        // Click Points Table
        log.info("Clicking on Points Table");
        pointsPage.clickPointsTable();

        // Get data
        log.info("Fetching top team details from Points Table");
        String topTeam = pointsPage.getTopTeamName();
        int matches = pointsPage.getTopTeamMatchesPlayed();
        int points = pointsPage.getTopTeamPoints();

        // Print
        log.info("Top Team: {}", topTeam);
        log.info("Matches Played: {}", matches);
        log.info("Points: {}", points);

        // Assertions
        if (!topTeam.equals(JsonDataProvider.getTopTeamName())) {
            log.error("Top team mismatch. Expected: {}, Actual: {}", JsonDataProvider.getTopTeamName(), topTeam);
        }
        Assert.assertEquals(topTeam, JsonDataProvider.getTopTeamName(), "Top team mismatch");

        if (matches != JsonDataProvider.getTopTeamMatches()) {
            log.error("Matches mismatch. Expected: {}, Actual: {}", JsonDataProvider.getTopTeamMatches(), matches);
        }
        Assert.assertEquals(matches, JsonDataProvider.getTopTeamMatches(), "Matches mismatch");

        if (points != JsonDataProvider.getTopTeamPoints()) {
            log.error("Points mismatch. Expected: {}, Actual: {}", JsonDataProvider.getTopTeamPoints(), points);
        }
        Assert.assertEquals(points, JsonDataProvider.getTopTeamPoints(), "Points mismatch");

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}