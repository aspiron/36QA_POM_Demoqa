package tests.BookStoreTests;

import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.BeforeMethod;
import pages.BookStorePages.LoginPage;
import pages.BookStorePages.ProfilePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

public class BookStoreLoginTests extends TestBase {

    // login data for demoqa.com:
    // alexpiron
    // 123qweQ!
    @BeforeMethod
    public void preconditions() {
        LoginPage lp = new LoginPage(dr);
        new Actions(dr).keyDown(Keys.PAGE_DOWN).perform();
        lp.goToBookStoreApp.click();
        pause(3000);
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(dr).login("alexpiron", "123qweQ!");
        pause(1500);

        ProfilePage pp = new ProfilePage(dr);
        Assert.assertTrue(pp.logoutButton.isDisplayed());
    }

    @Test
    public void authNegativeTest() {
        new LoginPage(dr).login("alexpiron", "alexpiron");
        String errorMsg = "Invalid username or password!";
        Assert.assertTrue(new LoginPage(dr).getErrorMessage().contains(errorMsg));
    }


}
