package tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage.UploadAndDownloadPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class UploadAndDownloadTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(dr).openElements();
        new SideMenu(dr).openUploadDownloadPage();
    }

    @Test
    public void clickOnDownLoadButton() {
        Assert.assertTrue(new UploadAndDownloadPage(dr).verifyDownload() );
    }

    @Test
    public void selectFileToUpload() {
        Assert.assertTrue(new UploadAndDownloadPage(dr).selectFile().checkFileIsSelected() );
    }


}
