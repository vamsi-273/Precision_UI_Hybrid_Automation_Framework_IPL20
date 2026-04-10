package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.AuctionPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuctionTest extends BaseTest {

    Logger log = LogManager.getLogger(AuctionTest.class);

    @Test
    public void validateAuctionPage() throws InterruptedException {

        log.info("---------------Case 6: Auction Page Test---------------");

        AuctionPage auctionPage = new AuctionPage(driver);

        // Open Auction Page
        log.info("Opening Auction Page");
        auctionPage.openAuctionPage();

        // Accept Cookies
        log.info("Accepting cookies if present");
        auctionPage.acceptCookies();

        // Wait for page load
        log.info("Waiting for page to load");
        Thread.sleep(2000);

        // Scroll
        log.info("Scrolling down to load auction data");
        auctionPage.slowScrollDown();

        // Click Top Buys
        log.info("Clicking on Top Buys section");
        auctionPage.clickTopBuys();

        // Get data
        log.info("Fetching top buy player details");
        String player = auctionPage.getTopPlayerName();
        int price = auctionPage.getTopPlayerPrice();

        // Print logs
        log.info("Top Buy Player: {}", player);
        log.info("Price: {}", price);

        // 🔥 Assertions with logs

        // Player name validation
        if (player.isEmpty()) {
            log.error("Player name is empty!");
        }
        Assert.assertFalse(player.isEmpty(), "Player name is empty");

        // Price validation
        if (price <= 0) {
            log.error("Invalid player price: {}", price);
        }
        Assert.assertTrue(price > 0, "Invalid player price");

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}