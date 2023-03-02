package pages.ElementsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ButtonsPage extends PageBase {
    public ButtonsPage(WebDriver dr) {
        super(dr);
    }


    @FindBy(id="doubleClickBtn")
    WebElement doubleClickBtn;
    @FindBy(id="rightClickBtn")
    WebElement rightClickBtn;
    @FindBy(id="doubleClickMessage")
    WebElement doubleClickMessage;
    @FindBy(id="rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage doubleClick(){
        Actions actions = new Actions(dr);
        wait(1000);
        actions.doubleClick(doubleClickBtn).perform();
        wait(1000);
        return this;
    }

    public String getDoubleClickMessage(){
        return doubleClickMessage.getText();
    }

    public ButtonsPage rightClick(){
        Actions actions = new Actions(dr);
        wait(1000);
        actions.contextClick(rightClickBtn).perform();
        wait(1000);
        return this;
    }

    public String getRightClickMessage(){
        return rightClickMessage.getText();
    }




}
