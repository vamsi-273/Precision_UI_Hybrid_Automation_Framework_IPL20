package tests;

import com.ipl.automation.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.ipl.automation.pages.NewsPage;
import org.testng.Assert;

public class SearchTest extends BaseTest {

    Logger log = LogManager.getLogger(SearchTest.class);

    @Test
    public void openNewsSection() {

        log.info("---------------Case 4: Search Test---------------");

        NewsPage newsPage = new NewsPage(driver);

        // Navigate to News
        log.info("Navigating to News section");
        newsPage.clickNewsTab();

        // Accept cookies
        newsPage.acceptCookies();

        // Search
        log.info("Performing search for: Auction 2026");
        newsPage.clickSearchIcon();
        newsPage.enterSearchText("Auction 2026");

        // Validate results
        log.info("Validating search results for relevance");

        boolean isRelevant = newsPage.isSearchResultRelevant("Auction 2026");

        if (!isRelevant) {
            log.error("No relevant article found for: Auction 2026");
        }
        Assert.assertTrue(isRelevant, "No relevant Auction 2026 article found");

        // Open first result
        log.info("Clicking on first search result");
        newsPage.clickFirstResult();

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}