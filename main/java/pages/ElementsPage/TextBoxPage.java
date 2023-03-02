package pages.ElementsPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.data.TextBoxData;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.Key;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(id = "userName")
    WebElement enterUserName;
    @FindBy(id = "userEmail")
    WebElement enterUserEmail;
    @FindBy(id = "currentAddress")
    WebElement enterCurrentAddress;

    @FindBy(id = "permanentAddress")
    WebElement enterPermanentAddress;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public void fillFormAndSubmit() throws IOException, UnsupportedFlavorException {
        hideAds();

        type(enterUserName, TextBoxData.FULLNAME);
        type(enterUserEmail, TextBoxData.EMAIL);
        type(enterCurrentAddress, TextBoxData.ADDRESS);

        Actions action = new Actions(dr);

        Keys cmdCtrl = getCtrlCmd();

        action.keyDown(enterCurrentAddress, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        String result = (String) contents.getTransferData(DataFlavor.stringFlavor);

        if (result == TextBoxData.ADDRESS) {
            action.sendKeys(Keys.TAB);
            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
        }


        clickWithJSExecutor(submitBtn, 0, 150);
    }


    @FindBy(id = "output")
    WebElement output;

    public String checkSubmittedData() {
        return output.getText();
    }


    public String getPermanentAddress() {
        System.out.println("Permanent address is " + enterPermanentAddress.getText());
        return enterPermanentAddress.getText();
    }
}
