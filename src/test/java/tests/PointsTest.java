package tests;

import com.ipl.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.ipl.automation.pages.PointsPage;
import org.testng.Assert;
import com.ipl.automation.utils.TestData;

public class PointsTest extends BaseTest {

    @Test
    public void openPointsTable() {

        PointsPage pointsPage = new PointsPage(driver);

        // Click Points Table
        pointsPage.clickPointsTable();

        // Get data
        String topTeam = pointsPage.getTopTeamName();
        int matches = pointsPage.getTopTeamMatchesPlayed();
        int points = pointsPage.getTopTeamPoints();

        // Print
        System.out.println("Rank 1 Team: " + topTeam);
        System.out.println("Matches: " + matches);
        System.out.println("Points: " + points);

        // Assertions
        Assert.assertEquals(topTeam, TestData.getTopTeamName(), "Top team mismatch");
        Assert.assertEquals(matches, TestData.getTopTeamMatches(), "Matches mismatch");
        Assert.assertEquals(points, TestData.getTopTeamPoints(), "Points mismatch");
    }
}