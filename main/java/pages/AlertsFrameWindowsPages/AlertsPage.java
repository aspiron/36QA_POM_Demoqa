package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

import java.time.Duration;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(id = "alertButton")
    WebElement simpleAlertBtn;

    @FindBy(id = "timerAlertButton")
    WebElement secondAlertBtn;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnSimpleAlert() {
        click(simpleAlertBtn);
        wait(500);
        dr.switchTo().alert().accept();
        return this;
    }

    public AlertsPage clickOnSecondAlert() {
        click(secondAlertBtn);
//        wait(5500);

        WebDriverWait waiting = new WebDriverWait(dr, Duration.ofSeconds(5));
        Alert myAlert = waiting.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();

//        dr.switchTo().alert().accept();
        return this;
    }

    public AlertsPage clickOnConfirmatedAlert(String action) {
        wait(500);
        click(confirmButton);
        wait(500);
        if (action == "OK") {
            dr.switchTo().alert().accept();
        }
        if (action == "Cancel") {
            dr.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmText;

    public String getConfirmText() {
        return confirmText.getText();
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    @FindBy(id="promptResult")
    WebElement promptResult;

    public void enterTextToPromptAlert(String text) {
        click(promtButton);
        dr.switchTo().alert().sendKeys(text);
        dr.switchTo().alert().accept();
    }

    public String getPromrtResult(){
        return promptResult.getText();
    }

}
