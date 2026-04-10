package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.VenuesPage;
import com.ipl.automation.utils.JsonDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VenuesTest extends BaseTest {

    Logger log = LogManager.getLogger(VenuesTest.class);

    @Test
    public void verifyVenuesFromJson() {

        log.info("---------------Case 6: Teams Hover Test---------------");

        VenuesPage venuesPage = new VenuesPage(driver);

        // Navigate to venues page
        venuesPage.goToVenues();
        log.info("Navigated to Venues page");

        // Get Venues data from UI
        List<String> actualVenues = venuesPage.getAllVenueNames();
        log.info("Venues data fetched");

        // Get JSON data
        List<String> expectedVenues = JsonDataProvider.getVenuesFromJson();
        log.info("Json data for venues fetched");

        // Validate venues
        log.info("Venue details are being verified");
        for (String venue : expectedVenues) {
            Assert.assertTrue(actualVenues.contains(venue), "Missing venue: " + venue);
        }

        log.info("All venues validated successfully");
        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}