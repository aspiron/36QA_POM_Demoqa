package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.Collection;
import java.util.List;

public class FramesPage extends PageBase {
    public FramesPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public int getFramesNumber() {
        // один из способов найт количество фреймов на странице:
        //return iframes.size();

        // второй способ:
        JavascriptExecutor js = (JavascriptExecutor) dr;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        return numberOfFrames;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramesPage switchToFrameById() {
        dr.switchTo().frame(frame1);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement h1;

    public String getH1() {
        return h1.getText();
    }
}
