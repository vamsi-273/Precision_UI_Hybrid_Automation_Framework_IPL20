package tests;

import com.ipl.automation.base.BaseTest;
import com.ipl.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void verifyFooterLinks() {
        HomePage homePage = new HomePage(driver);

        homePage.scrollToFooter();
        String footerLinkText = homePage.getFooterText();

        Assert.assertTrue(footerLinkText.contains("TEAM"));
        Assert.assertTrue(footerLinkText.contains("ABOUT"));
        Assert.assertTrue(footerLinkText.contains("GUIDELINES"));
        Assert.assertTrue(footerLinkText.contains("CONTACT"));
    }
}