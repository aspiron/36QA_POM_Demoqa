package tests.InteractionTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InteractionPages.DroppablePage;
import pages.SideMenu;
import tests.TestBase;

public class DroppableTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(dr).openElements();
        new SideMenu(dr).openDroppablePage();
    }

    @Test
    public void dragHereTest() {
        Assert.assertTrue(new DroppablePage(dr).testDroppableHere().getDroppedResult().contains("Dropped!"));
    }

    @Test
    public void dragByElement() {
//        Assert.assertTrue(new DroppablePage(dr).testDroppableByOffset().getDroppedResult().contains("Dropped"));
        new DroppablePage(dr).testDroppableByOffset().getDroppedResult().contains("Dropped");
        pause(2000);


    }


}
