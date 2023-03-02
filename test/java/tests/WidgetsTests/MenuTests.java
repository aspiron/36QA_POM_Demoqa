package tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.MenuPage;
import tests.TestBase;

public class MenuTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
//        new HomePage(dr).openWidgetsPage();
//        new SideMenu(dr).openMenuPage();
//
        dr.get("https://demoqa.com/menu");
    }

    @Test
    public void checkSubSubMenu(){
        Assert.assertTrue( new MenuPage(dr).openSubSubMenu().getSubSubItemText().contains("Item 1") );
    }



}
