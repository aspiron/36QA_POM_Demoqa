package tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage.BrokenLinksImagesPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class BrokenLinksImagesTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
            new HomePage(dr).openElements();
            new SideMenu(dr).openBrokenLinksImages();
    }

    @Test
    public void checkBrokenImages(){
        Assert.assertTrue(new BrokenLinksImagesPage(dr).checkNoBrokenImages()==0);
    }

    @Test
    public void checkBrokenLinks(){
        Assert.assertEquals(new BrokenLinksImagesPage(dr).checkNumberBrokenLinks(), 0);
    }



}
