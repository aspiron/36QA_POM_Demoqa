package pages.data;

import org.openqa.selenium.WebDriver;
import pages.PageBase;

public class LoginData extends PageBase {
    public LoginData(WebDriver dr) {
        super(dr);
    }

    public static final String USERNAME = "alexpiron";
    public static final String PASSWORD = "123qweQ!";
}
