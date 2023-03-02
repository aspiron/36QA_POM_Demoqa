package tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage.RadioButtonPage;
import pages.HomePage;
import pages.PageBase;
import pages.SideMenu;
import tests.TestBase;

public class RadioButtonTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        new HomePage(dr).openElements();
        new SideMenu(dr).openRadioButtons();
    }

    @Test
    public void selectRadioButtons() {
        Assert.assertTrue( new RadioButtonPage(dr).selectYes().checkSelected().contains("Yes") );
    }
}
