package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.TicketsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketsTest extends BaseTest {

    Logger log = LogManager.getLogger(TicketsTest.class);

    @Test
    public void verifyBuyTicketsFlow() {

        log.info("---------------Case 5: Teams Hover Test---------------");

        TicketsPage ticketsPage = new TicketsPage(driver);

        // Navigate to tickets page
        ticketsPage.goToTickets();
        log.info("Navigated to Tickets tab");

        // Accept cookies
        ticketsPage.acceptCookies();

        // Verify button
        boolean isEnabled = ticketsPage.isBuyTicketsEnabled();
        Assert.assertTrue(isEnabled, "Buy Tickets button is NOT enabled");
        log.info("Buy Tickets button is enabled");

        // Click buy tickets
        boolean isNewTabOpened = ticketsPage.isNewTabOpenedAfterClick();
        Assert.assertTrue(isNewTabOpened, "New tab did NOT open after clicking Buy Tickets");
        log.info("New booking tab opened successfully");

        // Click Match Center button
        ticketsPage.clickMatchCentre();

        // Is venue details visible
        log.info("Match center button clicked");
        Assert.assertTrue(ticketsPage.isVenueVisible(), "Venue details not visible");
        log.info("Venue details are visible");
        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}