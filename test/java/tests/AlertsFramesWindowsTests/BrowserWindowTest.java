package tests.AlertsFramesWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;
import tests.TestBase;

public class BrowserWindowTest extends TestBase {
    @BeforeMethod
    public void preconditions(){
        dr.get("https://demoqa.com/browser-windows");
    }

    @Test
    public void openNewTabTest() {
        new BrowserWindowsPage(dr).openNewTab();
        Assert.assertTrue(new BrowserWindowsPage(dr).getNewPageHeading().contains("This is a sample page"));
    }

    @Test
    public void openNewWindowTest() {
        new BrowserWindowsPage(dr).openNewWindow();
        Assert.assertTrue(new BrowserWindowsPage(dr).getNewPageHeading().contains("This is a sample page"));
    }

    @Test
    public void openNewMessageWindowTest() {
        new BrowserWindowsPage(dr).openNewMessageWindow();
        Assert.assertTrue(new BrowserWindowsPage(dr).getNewPageHeadingForMessageWindow()
                .contains("Knowledge increases by sharing but not by saving"));
    }

}
