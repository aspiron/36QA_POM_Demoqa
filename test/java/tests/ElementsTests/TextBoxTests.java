package tests.ElementsTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ElementsPage.TextBoxPage;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.SelectMenuPage;
import pages.data.TextBoxData;
import tests.TestBase;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void precondits() {
        new HomePage(dr).openElements();
        new SideMenu(dr).openTextBox();
    }

    @Test
    public void simpleFormSubmitTest() throws IOException, UnsupportedFlavorException {
        new TextBoxPage(dr).fillFormAndSubmit();
        Assert.assertTrue(new TextBoxPage(dr).checkSubmittedData().contains(TextBoxData.FULLNAME));
        Assert.assertTrue(new TextBoxPage(dr).checkSubmittedData().contains(TextBoxData.ADDRESS));
        Assert.assertTrue(new TextBoxPage(dr).checkSubmittedData().contains(TextBoxData.EMAIL));
        Assert.assertEquals(new TextBoxPage(dr).getPermanentAddress(), TextBoxData.ADDRESS);

        // Step 1: Fill in the full name input with John Doe value
        // Step 2: Fill in the email input with john@doe.com
        // Step 3: Fill in the current address with "10318, Germany, Berlin, Marksburgstrasse 1," data
        // Step 4: Copy value from the Current Address text area to Permanent Address textarea
        // Step 5: Submit the form
        // Expected results: All data from steps1-4 is presented in the output div.

    }




}
