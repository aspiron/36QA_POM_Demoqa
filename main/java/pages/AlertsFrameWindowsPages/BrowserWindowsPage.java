package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v107.browser.Browser;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(id = "tabButton")
    WebElement newTabBtn;

    @FindBy(id = "windowButton")
    WebElement newWindowBtn;

    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageBtn;

    public BrowserWindowsPage openNewTab(){
        click(newTabBtn);
        // первый способ:
//        String thisWindow = dr.getWindowHandle();
        List<String> allWindows = new ArrayList<>(dr.getWindowHandles());
        String tabName = allWindows.get(1);
        dr.switchTo().window(tabName);
    return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement newPageHeading;

    @FindBy(partialLinkText = "Knowledge increases by sharing but not by saving")
    WebElement newMessageWindowText;

    public String getNewPageHeading(){
        return newPageHeading.getText();
    }

    public String getNewPageHeadingForMessageWindow(){
        return newMessageWindowText.getText();
    }

    public BrowserWindowsPage openNewWindow(){
        click(newWindowBtn);
        // второй способ:
        String thisWindow = dr.getWindowHandle();
        for (String windowH : dr.getWindowHandles()){
            if (!thisWindow.contentEquals(windowH)){
                dr.switchTo().window(windowH);
                break;
            }
        }
        return this;
    }

    public BrowserWindowsPage openNewMessageWindow(){
        click(newWindowMessageBtn);
        wait(1000);
        String thisWindow = dr.getWindowHandle();
        for (String windowH : dr.getWindowHandles()){
            if (!thisWindow.contentEquals(windowH)){
                dr.switchTo().window(windowH);
                break;
            }
        }
        return this;
    }

}
