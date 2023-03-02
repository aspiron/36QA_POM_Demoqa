package tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage.ButtonsPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class ButtonsTests extends TestBase {
    @BeforeMethod
    public void  preconditions(){
        new HomePage(dr).openElements();
        new SideMenu(dr).openButtonsPage();
    }

    @Test
    public void doubleClickButtonTest(){
        Assert.assertTrue(new ButtonsPage(dr).doubleClick().getDoubleClickMessage().contains("double"));
    }

    @Test
    public void rightClickButtonTest() {
        Assert.assertTrue(new ButtonsPage(dr).rightClick().getRightClickMessage().contains("right"));
    }
}
