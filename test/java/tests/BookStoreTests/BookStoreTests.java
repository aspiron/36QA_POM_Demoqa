package tests.BookStoreTests;

import pages.BookStorePages.BookStorePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestBase;

public class BookStoreTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(dr).openBookStoreApp();
    }


    @Test
    public void searchForBookTest(){
        new BookStorePage(dr).searchBook("Web");
        Assert.assertTrue(new BookStorePage(dr).getFirstBookTitle().contains("Web"));
    }

}
