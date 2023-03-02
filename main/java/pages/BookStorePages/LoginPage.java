package pages.BookStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    public
    WebElement goToBookStoreApp;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "userName")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    public ProfilePage login(String loginData, String passwordData) {
        click(loginButton);
        type(usernameField, loginData);
        type(passwordField, passwordData);
        click(loginButton);
        return new ProfilePage(dr);
    }


    @FindBy(id = "name")
    WebElement errorMsg;

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    @FindBy(id = "submit")
    WebElement logoutButton;

    public LoginPage logOut() {
        click(logoutButton);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/h5")
    WebElement welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }


}
