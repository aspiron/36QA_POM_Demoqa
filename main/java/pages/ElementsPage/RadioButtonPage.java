package pages.ElementsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class RadioButtonPage extends PageBase {
    public RadioButtonPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "//label[.='Yes']")
    WebElement labelYes;

    public RadioButtonPage selectYes() {
        hideAds();

        labelYes.click();
        return this;
    }

    @FindBy(xpath="//span[@class='text-success']")
    WebElement textSuccess;
    public String checkSelected() {
        return textSuccess.getText();
    }

}
