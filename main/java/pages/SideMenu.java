package pages;

import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.BookStorePages.BookStorePage;
import pages.BookStorePages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BookStorePages.ProfilePage;
import pages.ElementsPage.*;
import pages.InteractionPages.DroppablePage;
import pages.WidgetsPage.MenuPage;

public class SideMenu extends PageBase {
    public SideMenu(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        wait(500);
        return new LoginPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    WebElement openAlertsPage;

    public AlertsPage openAlerts() {
        goDown(Keys.PAGE_DOWN);
        click(openAlertsPage);
        return new AlertsPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]]")
    WebElement profilePageLink;

    public ProfilePage openProfilePage() {
        clickWithJSExecutor(profilePageLink, 0, 300);
        return new ProfilePage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]/span")
    WebElement bookStorePageLink;

    public BookStorePage openBookStorePage() {
        clickWithJSExecutor(bookStorePageLink, 0, 500);
        return new BookStorePage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]")
    WebElement textBoxBtn;

    public TextBoxPage openTextBox() {
        click(textBoxBtn);
        return new TextBoxPage(dr);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsLink;

    public ButtonsPage openButtonsPage() {
        clickWithJSExecutor(buttonsLink, 0, 200);
        return new ButtonsPage(dr);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadDownloadLink;

    public UploadAndDownloadPage openUploadDownloadPage() {
        clickWithJSExecutor(uploadDownloadLink, 0, 250);
        return new UploadAndDownloadPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[7]")
    WebElement brokenLinksImagesLink;

    public BrokenLinksImagesPage openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 350);
        return new BrokenLinksImagesPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/span/div/div[1]")
    WebElement droppableLink;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[4]/span")
    WebElement droppablePageLink;

    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 700);
        click(droppablePageLink);
        return new DroppablePage(dr);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menuPageLink;

    public MenuPage openMenuPage() {
        clickWithJSExecutor(menuPageLink, 0, 500);
        return new MenuPage(dr);
    }

    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonLink;

    public RadioButtonPage openRadioButtons() {
        clickWithJSExecutor(radioButtonLink, 0, 300);

        return new RadioButtonPage(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li")
    WebElement practiceFormLink;

    public PracticeFormPage openPracticeForm() {
        click(practiceFormLink);
        return new PracticeFormPage(dr);
    }

}
