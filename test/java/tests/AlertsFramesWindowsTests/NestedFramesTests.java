package tests.AlertsFramesWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.NestedFramesPage;
import tests.TestBase;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        dr.get("https://demoqa.com/nestedframes");
    }


    @Test
    public void verifyTextInParentAndChildFramesTest(){
        Assert.assertTrue(new NestedFramesPage(dr).getParentFrameText().contains("Parent"));
        Assert.assertTrue(new NestedFramesPage(dr).getChildFrameText().contains("Child"));
    }
}
