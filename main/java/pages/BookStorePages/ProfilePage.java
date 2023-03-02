package pages.BookStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.Collection;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/button")
    public
    WebElement logoutButton;

    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(dr);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public String getUserNameValue() {
        return userNameValue.getText();
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span")
    WebElement firstBookTitle;

    public String getFirstBookTitle() {
        return firstBookTitle.getText();
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[5]/div/span")
    WebElement deleteBtn;
    @FindBy(id = "closeSmallModal-ok")
    WebElement closeModalOkBtn;

    public ProfilePage  deleteBook() {
        click(deleteBtn);
        wait(500);
        click(closeModalOkBtn);
        wait(500);
        dr.switchTo().alert().accept();
        return this;
    }
}
