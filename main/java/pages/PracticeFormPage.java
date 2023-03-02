package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.data.PracticeData;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver dr) {
        super(dr);
    }


    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "userEmail")
    WebElement emailField;

    public PracticeFormPage enterNameAndEmail(String firstName, String lastName, String email) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        wait(1000);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/label")
    WebElement genderRadioButton;

    public PracticeFormPage chooseGender() {
        genderRadioButton.click();
        wait(1000);
        return this;
    }

    @FindBy(id = "userNumber")
    WebElement userNumberField;
    @FindBy(id = "currentAddress")
    WebElement addressField;


    public PracticeFormPage enterMobileNumber() {
        type(userNumberField, PracticeData.MOB_NUMBER);
        wait(1000);
        return this;
    }

    @FindBy(id = "subjectsContainer")
    WebElement subjectsSelect;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[8]/div[1]")
    WebElement freeSpaceOnThePage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]/div[1]")
    WebElement math;

    public PracticeFormPage selectSubjects() {
        Actions act = new Actions(dr);
        act.sendKeys(subjectsSelect, "Maths", Keys.ENTER).perform();
        click(math);
        click(freeSpaceOnThePage);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[1]/label")
    WebElement checkbox_1;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[2]/label")
    WebElement checkbox_2;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[3]/label")
    WebElement checkbox_3;

    public PracticeFormPage chooseHobbies() {
        click(checkbox_1);
        click(checkbox_2);
        click(checkbox_3);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        type(currentAddress, address);
        wait(1000);
        return this;
    }

    public void pageDown() {
        Actions a = new Actions(dr);
        a.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "city")
    WebElement city;

    public PracticeFormPage selectStateAndCity() {
        click(state);
        Actions a = new Actions(dr);
        a.click(state).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
        a.click(city).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
        return this;
    }

    @FindBy(id = "closeLargeModal")
    WebElement closeBtn;

    public PracticeFormPage submitData() {
        click(subjectsSelect);
        Actions a = new Actions(dr);
        a.sendKeys(Keys.ENTER).perform();
        a.sendKeys(Keys.PAGE_DOWN).perform();
        return this;
    }

    public PracticeFormPage closeModalWindow() {
        click(closeBtn);
        return this;
    }
}
