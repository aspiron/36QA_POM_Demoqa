package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PracticeFormPage;
import pages.SideMenu;
import pages.data.PracticeData;

public class TaskFormTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(dr).openForms();
        new SideMenu(dr).openPracticeForm();
        new PracticeFormPage(dr).hideAds();
    }

    @Test
    public void practiceFormPositiveTest() {

        new PracticeFormPage(dr).enterNameAndEmail(PracticeData.FIRST_NAME, PracticeData.LAST_NAME, PracticeData.EMAIL)
                .chooseGender()
                .enterMobileNumber()
                .pageDown();
        pause(2000);
        new PracticeFormPage(dr).chooseHobbies().enterAddress(PracticeData.ADDRESS);
        pause(2500);
        new PracticeFormPage(dr).selectSubjects().selectStateAndCity().submitData();

        Assert.assertTrue(dr.getPageSource().contains(PracticeData.FIRST_NAME));
        Assert.assertTrue(dr.getPageSource().contains(PracticeData.LAST_NAME));
        Assert.assertTrue(dr.getPageSource().contains(PracticeData.EMAIL));
        Assert.assertTrue(dr.getPageSource().contains(PracticeData.ADDRESS));
        Assert.assertTrue(dr.getPageSource().contains("Male"));
        Assert.assertTrue(dr.getPageSource().contains(PracticeData.MOB_NUMBER));
        Assert.assertTrue(dr.getPageSource().contains("Maths"));
        Assert.assertTrue(dr.getPageSource().contains("Sports, Reading, Music"));

        new PracticeFormPage(dr).closeModalWindow();

//        new PracticeFormPage(dr).selectPicture();

    }
}
