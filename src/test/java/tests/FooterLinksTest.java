package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FooterLinksTest extends BaseTest {

    Logger log = LogManager.getLogger(FooterLinksTest.class);

    @Test
    public void verifyFooterLinks() {

        log.info("---------------Case 1: Footer Links Test---------------");

        log.info("Opening Home Page");
        HomePage homePage = new HomePage(driver);

        log.info("Scrolling to footer");
        homePage.scrollToFooter();

        log.info("Validating TEAM section links");
        Assert.assertFalse(homePage.getTeamLinks().isEmpty(), "TEAM section has no links");

        log.info("Validating ABOUT section links");
        Assert.assertFalse(homePage.getAboutLinks().isEmpty(), "ABOUT section has no links");

        log.info("Validating GUIDELINES section links");
        Assert.assertFalse(homePage.getGuidelineLinks().isEmpty(), "GUIDELINES section has no links");

        log.info("Validating CONTACT section links");
        Assert.assertFalse(homePage.getContactLinks().isEmpty(), "CONTACT section has no links");

        log.info("Footer validation completed successfully");

        log.info("---------------Test Case Completed---------------");
        log.info("");
    }
}