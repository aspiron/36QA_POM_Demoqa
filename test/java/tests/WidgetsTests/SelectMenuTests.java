package tests.WidgetsTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WidgetsPage.SelectMenuPage;
import tests.TestBase;

import java.util.List;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void preconds(){
        dr.get("https://demoqa.com/select-menu");
    }

    @Test
    public void fillInTwoSelectFields() {
        Assert.assertTrue( new SelectMenuPage(dr).choseFromSelectValue().getSelectValueText().contains("Group 1") );
        Assert.assertTrue( new SelectMenuPage(dr).choseFromSelectOne().getSelectOneText().contains("Prof.") );
    }


    @Test
    public void oldStyleMenuTest(){
        SelectMenuPage ourPage = new SelectMenuPage(dr);
        ourPage.choseYellowFromOldMenu();
        String ourText = ourPage.getOldStyleSelectValueText();
        Assert.assertTrue(ourText.contains("Yellow"));
    }

    @Test
    public void multiSelectTest(){
        List<WebElement> cars = new SelectMenuPage(dr).chooseTwoCars().multiSelectText();
        Assert.assertTrue(cars.get(0).getText().contains("Volvo"));
        Assert.assertTrue(cars.get(1).getText().contains("Opel"));
    }


}
