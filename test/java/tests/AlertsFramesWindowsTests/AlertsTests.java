package tests.AlertsFramesWindowsTests;

import pages.AlertsFrameWindowsPages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(dr).openAlertsFrameWindowsPage();
        new SideMenu(dr).openAlerts();
    }

    @Test
    public void invokeAlert(){
        new AlertsPage(dr).clickOnSimpleAlert();
    }

    @Test
    public void alertWithPausedAccept(){
        new AlertsPage(dr).clickOnSecondAlert();
    }

    @Test
    public void alertWithConfirmation(){
        Assert.assertTrue(new AlertsPage(dr).clickOnConfirmatedAlert("OK").getConfirmText().contains("Ok"));
        Assert.assertTrue(new AlertsPage(dr).clickOnConfirmatedAlert("Cancel").getConfirmText().contains("Cancel"));
    }

    @Test
    public void alertWithPromptBox(){
        String text = "blablabla";
        new AlertsPage(dr).enterTextToPromptAlert(text);
        Assert.assertTrue(new AlertsPage(dr).getPromrtResult().contains(text));
    }
}
