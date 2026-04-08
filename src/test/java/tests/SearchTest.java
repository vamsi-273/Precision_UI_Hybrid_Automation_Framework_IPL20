package tests;

import com.ipl.automation.base.BaseTest;
import org.testng.annotations.Test;
import com.ipl.automation.pages.NewsPage;
import org.testng.Assert;

public class SearchTest extends BaseTest {

    @Test
    public void openNewsSection() {

        NewsPage newsPage = new NewsPage(driver);

        // Navigate to News
        newsPage.clickNewsTab();
        System.out.println("Navigated to News section");

        // Accept cookies
        newsPage.acceptCookies();

        // Search
        newsPage.clickSearchIcon();
        newsPage.enterSearchText("Auction 2026");

        // Validate results
        boolean isRelevant = newsPage.isSearchResultRelevant("Auction 2026");

        Assert.assertTrue(isRelevant, "No relevant Auction 2026 article found");

        // Open first result
        newsPage.clickFirstResult();
    }
}