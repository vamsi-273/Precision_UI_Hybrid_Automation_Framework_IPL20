package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.StatsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.Assert;

public class StatsTest extends BaseTest {

    Logger log = LogManager.getLogger(StatsTest.class);

    @Test
    public void openStatsPageTest() throws InterruptedException {

        log.info("---------------Case 7: Stats Page Test---------------");

        StatsPage statsPage = new StatsPage(driver);

        // Navigate to Stats Page
        log.info("Opening Stats Page");
        statsPage.openStatsPage();

        // Accept cookies
        log.info("Accepting cookies if present");
        statsPage.acceptCookies();

        // Scroll
        log.info("Scrolling down to load stats");
        statsPage.slowScrollDown();

        // Wait
        log.info("Waiting for data to load");
        Thread.sleep(2000);

        // Fetch data
        log.info("Fetching top player details");
        String player = statsPage.getTopPlayerName();
        int runs = statsPage.getTopPlayerRuns();

        // Print logs
        log.info("Top Player: {}", player);
        log.info("Runs: {}", runs);

        // Assertions with logs

        // 1. Player name should not be empty
        if (player.isEmpty()) {
            log.error("Player name is empty!");
        }
        Assert.assertFalse(player.isEmpty(), "Player name is empty");

        // 2. Runs should be > 0
        if (runs <= 0) {
            log.error("Invalid runs value: {}", runs);
        }
        Assert.assertTrue(runs > 0, "Runs should be greater than 0");

        // 3. Runs should be realistic
        if (runs >= 1000) {
            log.error("Runs value looks invalid: {}", runs);
        }
        Assert.assertTrue(runs < 1000, "Runs value looks invalid");

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}