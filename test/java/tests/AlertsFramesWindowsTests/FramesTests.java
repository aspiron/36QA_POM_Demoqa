package tests.AlertsFramesWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.FramesPage;
import tests.TestBase;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void reconditions() {
        dr.get("https://demoqa.com/frames");
    }

    @Test(enabled = false)
    public void checkNumberOfFramesTest() {
        Assert.assertEquals(new FramesPage(dr).getFramesNumber(), 2);
    }

    @Test
    public void switchToFrameTest(){
      Assert.assertTrue( new FramesPage(dr).switchToFrameById().getH1().contains("sample page") );
    }

}
