package pages;

import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.BookStorePages.BookStorePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.ElementsPage.TextBoxPage;
import pages.WidgetsPage.MenuPage;

public class HomePage extends PageBase {
    public HomePage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;

    public BookStorePage openBookStoreApp() {
        clickWithJSExecutor(bookStoreAppLink, 0, 300);
        return new BookStorePage(dr);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]")
    WebElement alertsFramesWindowsLink;

    public AlertsPage openAlertsFrameWindowsPage() {
        new Actions(dr).keyDown(Keys.PAGE_DOWN).perform();
        click(alertsFramesWindowsLink);
        return new AlertsPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/div")
    WebElement elementsBtn;

    public TextBoxPage openElements() {
        click(elementsBtn);
        wait(1000);
        return new TextBoxPage(dr);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div")
    WebElement widgetsLink;

    public MenuPage openWidgetsPage() {
        clickWithJSExecutor(widgetsLink, 0, 100);
        return new MenuPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[2]")
    WebElement formsLink;

    public PracticeFormPage openForms() {
        click(formsLink);
        return new PracticeFormPage(dr);
    }

}
