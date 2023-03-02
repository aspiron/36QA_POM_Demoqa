package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.Collection;
import java.util.List;

public class NestedFramesPage extends PageBase {
    public NestedFramesPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(xpath = "/html/body")
    WebElement bodyFrame1;

    public String getParentFrameText() {
        dr.switchTo().frame(frame1);
        String body = bodyFrame1.getText();
        dr.switchTo().defaultContent();
        return body;
    }

    @FindBy(xpath = "/html/body/p")
    WebElement paragraph;

    public String getChildFrameText() {
        dr.switchTo().frame(frame1);
        dr.switchTo().frame(0);
        String p = paragraph.getText();
        dr.switchTo().parentFrame();
        dr.switchTo().defaultContent();
        return p;
    }
}
