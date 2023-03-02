package tests.BookStoreTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookStorePages.BookStorePage;
import pages.BookStorePages.LoginPage;
import pages.BookStorePages.ProfilePage;
import pages.HomePage;
import pages.SideMenu;
import pages.data.LoginData;
import tests.TestBase;

public class BookStoreSmokeTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
//        new HomePage(dr).openBookStoreApp();
//        new BookStorePage(dr).openLoginPage();
//        LoginPage lp = new LoginPage(dr);
//        new Actions(dr).keyDown(Keys.PAGE_DOWN).perform();
//        lp.goToBookStoreApp.click();
    dr.get("https://demoqa.com/login");
    }

    @Test
    public void bookStoreSmokeTest() {
        new LoginPage(dr).login(LoginData.USERNAME, LoginData.PASSWORD);
        pause(2000);
        new SideMenu(dr).openBookStorePage();
//        pause(2000);
        new BookStorePage(dr).searchBook("Web").openFirstBook();
        pause(1000);
        new BookStorePage(dr).addToCollection();

//        new SideMenu(dr).openProfilePage();
        pause(1000);
        dr.get("https://demoqa.com/profile");
        String title = "Web";
        Assert.assertTrue(new ProfilePage(dr).getFirstBookTitle().contains(title));

    }


    @AfterMethod
    public void deleteBookAndLogout() {
        new ProfilePage(dr).deleteBook().logout();
    }
}
