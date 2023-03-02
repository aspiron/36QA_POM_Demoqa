package pages.WidgetsPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

import java.util.List;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver dr) {
        super(dr);
    }


    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div")
    WebElement selectValueSelect;

    @FindBy(id = "selectMenuContainer")
    WebElement containerFreeSpace;

    public SelectMenuPage choseFromSelectValue() {
        //type(selectValueSelect, "Group 1");
        Actions actions = new Actions(dr);
        actions.sendKeys(selectValueSelect, "Group 1, option 1" + Keys.ENTER).perform();
        click(containerFreeSpace);
        wait(3000);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"selectOne\"]/div/div[1]")
    WebElement selectValueOne;

    public SelectMenuPage choseFromSelectOne() {
        Actions actions = new Actions(dr);
        actions.sendKeys(selectValueOne, "Prof" + Keys.ENTER).perform();
        click(containerFreeSpace);
        wait(3000);
        return this;
    }


    public String getSelectValueText() {
        return selectValueSelect.getText();
    }

    public String getSelectOneText() {
        return selectValueOne.getText();
    }


    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage choseYellowFromOldMenu() {
        Select select = new Select(oldSelectMenu);
        select.selectByValue("3");
        return this;
    }


    public String getOldStyleSelectValueText() {
        Select select = new Select(oldSelectMenu);
        return select.getFirstSelectedOption().getText();
    }

    @FindBy(id = "cars")
    WebElement multiSelect;

    public SelectMenuPage chooseTwoCars() {
    Select select = new Select(multiSelect);
    select.selectByValue("volvo");
    select.selectByValue("opel");
    return this;
    }

    public List<WebElement> multiSelectText(){
        Select select = new Select(multiSelect);
        return select.getAllSelectedOptions();
    }

}
