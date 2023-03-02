package pages.BookStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        this.wait(500);
        return new LoginPage(dr);
    }


    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage searchBook(String web) {
        type(searchBox, web);
        wait(500);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
    WebElement firstBook;

    public String getFirstBookTitle() {
        return firstBook.getText();
    }

    public BookStorePage openFirstBook() {
        click(firstBook);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]")
    WebElement addNewRecordButton;

    public BookStorePage addToCollection() {
        clickWithJSExecutor(addNewRecordButton, 0, 250);
        wait(2000);
        dr.switchTo().alert().accept();
        return this;
    }


}
